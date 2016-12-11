/*
 * ACDD Project
 * file ResourceSymBuilder.java   is  part of ACCD
 * The MIT License (MIT)  Copyright (c) 2015 Bunny Blue.
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.bunnyblue.acdd.resources;

import io.github.bunnyblue.acdd.resources.util.FileUtil;
import io.github.bunnyblue.acdd.resources.xml.ResNode;
import javassist.*;
import javassist.bytecode.FieldInfo;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipFile;

/**
 * Created by BunnyBlue on 12/12/15.
 */
public class ResourceSymBuilder {
    ClassPool pool = ClassPool.getDefault();
    File tmpDir=new File("symbol/resource");
    public void buildRootClass(ResRoot resRoot, String packageName) throws NotFoundException, CannotCompileException {
        if (tmpDir.isDirectory()){
            FileUtil.deleteDir(tmpDir);

        }
            tmpDir.mkdirs();
        System.err.println(tmpDir.getAbsolutePath());

        genClass(packageName , new ArrayList<ResNode>());
        genClass(packageName + "$" + "anim", resRoot.getAnim());
        genClass(packageName + "$" + "animator", resRoot.getAnimator());
        genClass(packageName + "$" + "array", resRoot.getArray());
        genClass(packageName + "$" + "attr", resRoot.getAttr());
        genClass(packageName + "$" + "bool", resRoot.getBool());
        genClass(packageName + "$" + "color", resRoot.getColor());
        genClass(packageName + "$" + "dimen", resRoot.getDimen());
        genClass(packageName + "$" + "drawable", resRoot.getDrawable());
        genClass(packageName + "$" + "fraction", resRoot.getFraction());
        genClass(packageName + "$" + "id", resRoot.getId());
        genClass(packageName + "$" + "integer", resRoot.getInteger());
        genClass(packageName + "$" + "interpolator", resRoot.getInterpolator());
        genClass(packageName + "$" + "layout", resRoot.getLayout());
        genClass(packageName + "$" + "menu", resRoot.getMenu());
        genClass(packageName + "$" + "mipmap", resRoot.getMipmap());
        genClass(packageName + "$" + "plurals", resRoot.getPlurals());
        genClass(packageName + "$" + "raw", resRoot.getRaw());
        genClass(packageName + "$" + "string", resRoot.getString());
        genClass(packageName + "$" + "transition", resRoot.getTransition());
        genClass(packageName + "$" + "xml", resRoot.getXml());
        genClass(packageName + "$" + "style", resRoot.getStyle());
       File res= new File("symbol/acdd_resources.jar");
        ZipUtil.pack(tmpDir,res);


    }

    private void genClass(String name, ArrayList<ResNode> nodes) throws NotFoundException, CannotCompileException {

        CtClass rootClass = pool.makeClass(name);
        for (ResNode node : nodes) {
            CtField ctField = new CtField(pool.getCtClass("int"), node.getName().replaceAll("\\.","_"), rootClass);
            ctField.setModifiers(Modifier.STATIC | Modifier.FINAL | Modifier.PUBLIC);
           if (node.getId()!=null){
            rootClass.addField(ctField, node.getId());
           }
        }

        try {
            rootClass.writeFile(tmpDir.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
