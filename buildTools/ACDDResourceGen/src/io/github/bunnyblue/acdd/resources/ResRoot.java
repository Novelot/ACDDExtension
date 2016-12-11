/*
 * ACDD Project
 * file ResRoot.java   is  part of ACCD
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

import java.util.ArrayList;

/**
 * Created by BunnyBlue on 12/12/15.
 */
public class ResRoot {
    private ArrayList<ResNode> anim = new ArrayList<>();
    private ArrayList<ResNode> animator = new ArrayList<>();
    private ArrayList<ResNode> array = new ArrayList<>();
    private ArrayList<ResNode> attr = new ArrayList<>();
    private ArrayList<ResNode> bool = new ArrayList<>();
    private ArrayList<ResNode> color = new ArrayList<>();
    private ArrayList<ResNode> dimen = new ArrayList<>();
    private ArrayList<ResNode> drawable = new ArrayList<>();
    private ArrayList<ResNode> fraction = new ArrayList<>();
    private ArrayList<ResNode> id = new ArrayList<>();
    private ArrayList<ResNode> integer = new ArrayList<>();
    private ArrayList<ResNode> interpolator = new ArrayList<>();
    private ArrayList<ResNode> layout = new ArrayList<>();
    private ArrayList<ResNode> menu = new ArrayList<>();
    private ArrayList<ResNode> mipmap = new ArrayList<>();
    private ArrayList<ResNode> plurals = new ArrayList<>();
    private ArrayList<ResNode> raw = new ArrayList<>();
    private ArrayList<ResNode> string = new ArrayList<>();
    private ArrayList<ResNode> style = new ArrayList<>();
    private ArrayList<ResNode> transition = new ArrayList<>();
    private ArrayList<ResNode> xml = new ArrayList<>();
    public ArrayList<ResNode> getStyle() {
        return style;
    }

    public ArrayList<ResNode> getAnim() {
        return anim;
    }

    public ArrayList<ResNode> getAnimator() {
        return animator;
    }

    public ArrayList<ResNode> getArray() {
        return array;
    }

    public ArrayList<ResNode> getAttr() {
        return attr;
    }

    public ArrayList<ResNode> getBool() {
        return bool;
    }

    public ArrayList<ResNode> getColor() {
        return color;
    }

    public ArrayList<ResNode> getDimen() {
        return dimen;
    }

    public ArrayList<ResNode> getDrawable() {
        return drawable;
    }

    public ArrayList<ResNode> getFraction() {
        return fraction;
    }

    public ArrayList<ResNode> getId() {
        return id;
    }

    public ArrayList<ResNode> getInteger() {
        return integer;
    }

    public ArrayList<ResNode> getInterpolator() {
        return interpolator;
    }

    public ArrayList<ResNode> getLayout() {
        return layout;
    }

    public ArrayList<ResNode> getMenu() {
        return menu;
    }

    public ArrayList<ResNode> getMipmap() {
        return mipmap;
    }

    public ArrayList<ResNode> getPlurals() {
        return plurals;
    }

    public ArrayList<ResNode> getRaw() {
        return raw;
    }

    public ArrayList<ResNode> getString() {
        return string;
    }

    public ArrayList<ResNode> getTransition() {
        return transition;
    }

    public ArrayList<ResNode> getXml() {
        return xml;
    }



    public void addNode(ResNode node) {
        switch (node.getType()) {
            case "anim":
                anim.add(node);
                break;
            case "animator":
                animator.add(node);
                break;
            case "array":
                array.add(node);
                break;
            case "attr":
                attr.add(node);
                break;
            case "bool":
                bool.add(node);
                break;
            case "color":
                color.add(node);
                break;
            case "dimen":
                dimen.add(node);
                break;
            case "drawable":
                drawable.add(node);
                break;
            case "fraction":
                fraction.add(node);
                break;
            case "id":
                id.add(node);
                break;
            case "integer":
                integer.add(node);
                break;
            case "interpolator":
                interpolator.add(node);
                break;
            case "layout":
                layout.add(node);
                break;
            case "menu":
                menu.add(node);
                break;
            case "mipmap":
                mipmap.add(node);
                break;
            case "plurals":
                plurals.add(node);
                break;
            case "raw":
                raw.add(node);
                break;
            case "xml":
                xml.add(node);
                break;
            case "string":
                string.add(node);
                break;
            case "style":
                style.add(node);
                break;
            case "transition":
                transition.add(node);
                break;
        }

    }

}
