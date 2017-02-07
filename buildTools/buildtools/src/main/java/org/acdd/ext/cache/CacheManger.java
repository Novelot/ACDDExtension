/**
 * ACDD Project
 * <p/>
 * The MIT License (MIT)
 * Copyright (c) 2015 Bunny Blue
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author BunnyBlue
 * */
package org.acdd.ext.cache;

import org.acdd.ext.bundleInfo.maker.ACDDFileUtils;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class CacheManger {
	static CacheManger sCacheManger=new CacheManger();
	JSONObject bundleMaps=new JSONObject();
	public static CacheManger getInstance() {
		return sCacheManger;
	}
	String  cacheFolder;
	public void initCacheDir(String folder) {
		cacheFolder=folder;
		File cache=new File(cacheFolder);
		if (!cache.exists()) {
			cache.mkdirs();
			System.out.println("CacheManger.initCacheDir(create  cache dir )"+cacheFolder);
		}
	}

	public boolean vaildCache(String path, String bundleConfigFile) {
		String configHash = ACDDFileUtils.getMD5(bundleConfigFile);
		if (configHash==null) {
			return false;
		}
		File newConfigFile = new File(cacheFolder, configHash);
		if (newConfigFile.exists() && newConfigFile.isFile()) {
			try {
				String content = FileUtils.readFileToString(newConfigFile);
				bundleMaps = new JSONObject(content);
				File dir = new File(path);
				File[] rcFiles = dir.listFiles(new FileFilter() {
					@Override
					public boolean accept(File pathname) {
						String path = pathname.getAbsolutePath();
						if (path.endsWith(".so") && (path.contains("libcom") || path.contains("liborg") || path.contains("libcn"))) {
							return true;
						}
						return false;
					}
				});
				for (File file : rcFiles) {
					String packageName = file.getName();
					packageName = packageName.substring(3, packageName.length() - 3).replace("_", ".");//cut "lib" & ".so", replace "_"

					String pkgHash = ACDDFileUtils.getMD5(file.getAbsolutePath());
					if (pkgHash.equals(bundleMaps.optString(packageName))) {
						bundleMaps.remove(packageName);
					} else {
						System.out.println("validCache=====find  unmatched pkg "+pkgHash);
						System.out.println("=====valid aborted, need produce new config file！！！");
						return false;
					}
				}
				if (bundleMaps.length()==0) {
					System.out.println("bundleMaps.length() == 0");
					return true;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}
	
	public void addNewItem(String bundleName,String bundleHash){
		try {
			bundleMaps.put(bundleName, bundleHash);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean storeData(String bundleConfigFile) {
		File cache=new File(cacheFolder);
		for (File oldFile : cache.listFiles()) {
			oldFile.delete();
		}
		cache.mkdirs();
		String configHash=ACDDFileUtils.getMD5(bundleConfigFile);
		File newConfigFile=new  File(cacheFolder, configHash);
		try {
			FileUtils.writeStringToFile(newConfigFile, bundleMaps.toString());
			System.out.println("=====wtrited  cache hash to "+newConfigFile);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
