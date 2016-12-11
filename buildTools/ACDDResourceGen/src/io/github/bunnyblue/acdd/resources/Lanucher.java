/*
 * ACDD Project
 * file Lanucher.java   is  part of ACCD
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

import io.github.bunnyblue.acdd.resources.xml.ResNode;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by BunnyBlue on 12/12/15.
 */
public class Lanucher {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("you need set resources file");
            return;
        }

        String path = args[0];
        String  packageName=args[1];
        try {
            packageName=packageName+".R";
            readXMl(path,packageName);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void readXMl(String path,String pkgName) throws DocumentException {
        ResRoot resRoot = new ResRoot();
        SAXReader reader = new SAXReader();
        File file = new File(path);
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element child : childElements) {
            if (child.attributeValue("type") != null && child.attributeValue("type").length() > 0) {
                ResNode resNode = new ResNode();
                resNode.setName(child.attributeValue("name")).setId(child.attributeValue("id")).setType(child.attributeValue("type"));
                resRoot.addNode(resNode);

            }


        }
        try {
            ResourceSymBuilder builder = new ResourceSymBuilder();
            builder.buildRootClass(resRoot, pkgName);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
}
