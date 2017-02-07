/**
 * OpenAtlasForAndroid Project
 * <p>
 * The MIT License (MIT)
 * Copyright (c) 2015 Bunny Blue
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * @author BunnyBlue
 **/
package org.acdd.ext.bundleInfo.maker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.acdd.ext.cache.CacheManger;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * @author BunnyBlue
 *
 */
public class BundleMakeBooter {
    public static void main(String[] args) throws JSONException, IOException {
        if (args.length < 2) {
            throw new IOException(" args to less , usage plugin_dir out_put_json_path cachedir");


        }

        String path = args[0];
        String targetFile = args[1];
        String cacheDir = args[2];
        ApkPreProcess.preProcess(path);

        CacheManger.getInstance().initCacheDir(cacheDir);
        if (CacheManger.getInstance().vaildCache(path, targetFile)) {
            System.out.println("no need produce new bundle config returned");
            return;
        }

        File dirFile = new File(path);
        JSONArray jsonArray = new JSONArray();
        File[] files = dirFile.listFiles();
        for (File file : files) {
            if (file.getAbsolutePath().contains("libcom") || file.getAbsolutePath().contains("libcn_")) {
                PackageLite packageLit = PackageLite.parse(file.getAbsolutePath());
                jsonArray.put(packageLit.getBundleInfo());
                CacheManger.getInstance().addNewItem(packageLit.packageName, ACDDFileUtils.getMD5(file.getAbsolutePath()));
//				try {
//					 packageLit.getBundleInfo().toString();
//				} catch (JSONException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
            }

        }
        org.apache.commons.io.FileUtils.writeStringToFile(new File(targetFile), jsonArray.toString());
        CacheManger.getInstance().storeData(targetFile);
        System.out.println(jsonArray.toString());
    }

}
