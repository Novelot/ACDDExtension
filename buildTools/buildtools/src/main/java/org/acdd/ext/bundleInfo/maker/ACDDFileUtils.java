/**
 * ACDD Project
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;

/**
 * @author BunnyBlue
 *
 */
public class ACDDFileUtils {
    /**
     * 获取指定文件 MD5
     *
     * @param pkgFilePath
     * @return
     */
    public static String getMD5(String pkgFilePath) {

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            File mFile = new File(pkgFilePath);
            if (!mFile.exists()) {
                return null;
            }
            FileInputStream in = new FileInputStream(mFile);
            FileChannel ch = in.getChannel();
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, mFile.length());
            messageDigest.update(byteBuffer);
            byte[] bytes = messageDigest.digest();
            final String HEX = "0123456789abcdef";
            StringBuilder sb = new StringBuilder(bytes.length * 2);
            for (byte b : bytes) {
                // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
                sb.append(HEX.charAt((b >> 4) & 0x0f));
                // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数
                sb.append(HEX.charAt(b & 0x0f));
            }
            clean(byteBuffer);
            ch.close();
            in.close();
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void clean(final Object buffer) throws Exception {
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    Method getCleanerMethod = buffer.getClass().getMethod("cleaner", new Class[0]);
                    getCleanerMethod.setAccessible(true);
                    sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(buffer, new Object[0]);
                    cleaner.clean();
//                    System.out.println("it shall be close");
                } catch (Exception e) {
                    System.out.println("sorry, MappedByteBuffer did'nt close: " + e.toString());
                }
                return null;
            }
        });

    }

}
