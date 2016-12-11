#ifndef __AaptExt__ACDDResource__
#define __AaptExt__ACDDResource__
#include <stdio.h>
#include <string>
#include <iostream>
#include <map>
using namespace std;
class ACDDResource {
        map<std::string,int> animMaps;
        map<std::string,int> animatorMaps;
        map<std::string,int> arrayMaps;
        map<std::string,int> attrMaps;
        map<std::string,int> boolMaps;
        map<std::string,int> colorMaps;
        map<std::string,int> dimenMaps;
        map<std::string,int> drawableMaps;
        map<std::string,int> fractionMaps;
        map<std::string,int> idMaps;
        map<std::string,int> integerMaps;
        map<std::string,int> interpolatorMaps;
        map<std::string,int> layoutMaps;
        map<std::string,int> menuMaps;
        map<std::string,int> mipmapMaps;
        map<std::string,int> pluralsMaps;
        map<std::string,int> rawMaps;
        map<std::string,int> stringMaps;
        map<std::string,int> styleMaps;
        map<std::string,int> transitionMaps;
        map<std::string,int> xmlMaps;



public:
        static ACDDResource* getInstance()
        {
                static ACDDResource instance;
                return &instance;
        }



        void setAnim(std::string resName,int resId);
        int getAnim(std::string resName);



        void setAnimator(std::string resName,int resId);
        int getAnimator(std::string resName);



        void setArray(std::string resName,int resId);
        int getArray(std::string resName);


        void setAttr(std::string resName,int resId);
        int getAttr(std::string resName);


        void setBool(std::string resName,int resId);
        int getBool(std::string resName);



        void setColor(std::string resName,int resId);
        int getColor(std::string resName);



        void setDimen(std::string resName,int resId);
        int getDimen(std::string resName);


        void setDrawable(std::string resName,int resId);
        int getDrawable(std::string resName);



        void setFraction(std::string resName,int resId);
        int getFraction(std::string resName);


        void setId(std::string resName,int resId);
        int getId(std::string resName);



        void setInteger(std::string resName,int resId);
        int getInteger(std::string resName);



        void setInterpolator(std::string resName,int resId);
        int getInterpolator(std::string resName);



        void setLayout(std::string resName,int resId);
        int getLayout(std::string resName);



        void setMenu(std::string resName,int resId);
        int getMenu(std::string resName);


        void setMipmap(std::string resName,int resId);
        int getMipmap(std::string resName);



        void setPlurals(std::string resName,int resId);
        int getPlurals(std::string resName);



        void setRaw(std::string resName,int resId);
        int getRaw(std::string resName);


        void setString(std::string resName,int resId);
        int getString(std::string resName);


        void setStyle(std::string resName,int resId);
        int getStyle(std::string resName);


        void setTransition(std::string resName,int resId);
        int getTransition(std::string resName);

        void setXml(std::string resName,int resId);
        int getXml(std::string resName);

protected:
        struct Object_Creator
        {
                Object_Creator()
                {
                        ACDDResource::getInstance();
                }
        };
        static Object_Creator _object_creator;

        ACDDResource(){
        };
        ~ACDDResource() {
        }

};
#endif
