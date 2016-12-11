#include <androidfw/acdd/ACDDResourceBridge.h>
#include <androidfw/acdd/ACDDAaptConfig.h>
bool endwith(std::string  path,std::string tail){


    bool ret = path.compare(path.size() - tail.size(), tail.size(), tail) == 0;
    return ret;
}
ACDDResourceBridge::Object_Creator ACDDResourceBridge::_object_creator;


std::string getIDType(std::string classLine){
    if (classLine.find_last_of("$")>0) {
        classLine=  classLine.substr(classLine.find_last_of("$")+1);
        return classLine.substr(0,classLine.find_first_of(" "));
    }
    return "";
}





void  ACDDResourceBridge::addResourceSymbol(std::string type,std::string resName,int value){



  if (!type.compare("anim")) {
          ACDDResource::getInstance()->setAnim(resName,value);
  }else
  if (!type.compare("animator")) {
          ACDDResource::getInstance()->setAnimator(resName,value);
  }else
  if (!type.compare("array")) {
          ACDDResource::getInstance()->setArray(resName,value);
  }else
  if (!type.compare("attr")) {
          ACDDResource::getInstance()->setAttr(resName,value);
  }else
  if (!type.compare("bool")) {
          ACDDResource::getInstance()->setBool(resName,value);
  }else
  if (!type.compare("color")) {
          ACDDResource::getInstance()->setColor(resName,value);
  }else
  if (!type.compare("dimen")) {
          ACDDResource::getInstance()->setDimen(resName,value);
  }else
  if (!type.compare("drawable")) {
          ACDDResource::getInstance()->setDrawable(resName,value);
  }else
  if (!type.compare("fraction")) {
          ACDDResource::getInstance()->setFraction(resName,value);
  }else
  if (!type.compare("id")) {
          ACDDResource::getInstance()->setId(resName,value);
  }else
  if (!type.compare("integer")) {
          ACDDResource::getInstance()->setInteger(resName,value);
  }else
  if (!type.compare("interpolator")) {
          ACDDResource::getInstance()->setInterpolator(resName,value);
  }else
  if (!type.compare("layout")) {
          ACDDResource::getInstance()->setLayout(resName,value);
  }else
  if (!type.compare("menu")) {
          ACDDResource::getInstance()->setMenu(resName,value);
  }else
  if (!type.compare("mipmap")) {
          ACDDResource::getInstance()->setMipmap(resName,value);
  }else
  if (!type.compare("plurals")) {
          ACDDResource::getInstance()->setPlurals(resName,value);
  }else
  if (!type.compare("raw")) {
          ACDDResource::getInstance()->setRaw(resName,value);
  }else
  if (!type.compare("string")) {
          ACDDResource::getInstance()->setString(resName,value);
  }else
  if (!type.compare("style")) {
          ACDDResource::getInstance()->setStyle(resName,value);
  }else
  if (!type.compare("transition")) {
          ACDDResource::getInstance()->setTransition(resName,value);
  }else
  if (!type.compare("xml")) {
          ACDDResource::getInstance()->setXml(resName,value);
  }else
  {}

};
int  ACDDResourceBridge::getResourceId(string type,string resName){
        if (!type.compare("anim")) {
                return ACDDResource::getInstance()->getAnim(resName);
        };
        if (!type.compare("animator")) {
                return ACDDResource::getInstance()->getAnimator(resName);
        };
        if (!type.compare("array")) {
                return ACDDResource::getInstance()->getArray(resName);
        };
        if (!type.compare("attr")) {
                return ACDDResource::getInstance()->getAttr(resName);
        };
        if (!type.compare("bool")) {
                return ACDDResource::getInstance()->getBool(resName);
        };
        if (!type.compare("color")) {
                return ACDDResource::getInstance()->getColor(resName);
        };
        if (!type.compare("dimen")) {
                return ACDDResource::getInstance()->getDimen(resName);
        };
        if (!type.compare("drawable")) {
                return ACDDResource::getInstance()->getDrawable(resName);
        };
        if (!type.compare("fraction")) {
                return ACDDResource::getInstance()->getFraction(resName);
        };
        if (!type.compare("id")) {
                return ACDDResource::getInstance()->getId(resName);
        };
        if (!type.compare("integer")) {
                return ACDDResource::getInstance()->getInteger(resName);
        };
        if (!type.compare("interpolator")) {
                return ACDDResource::getInstance()->getInterpolator(resName);
        };
        if (!type.compare("layout")) {
                return ACDDResource::getInstance()->getLayout(resName);
        };
        if (!type.compare("menu")) {
                return ACDDResource::getInstance()->getMenu(resName);
        };
        if (!type.compare("mipmap")) {
                return ACDDResource::getInstance()->getMipmap(resName);
        };
        if (!type.compare("plurals")) {
                return ACDDResource::getInstance()->getPlurals(resName);
        };
        if (!type.compare("raw")) {
                return ACDDResource::getInstance()->getRaw(resName);
        };
        if (!type.compare("string")) {
                return ACDDResource::getInstance()->getString(resName);
        };
        if (!type.compare("style")) {
                return ACDDResource::getInstance()->getStyle(resName);
        };
        if (!type.compare("transition")) {
                return ACDDResource::getInstance()->getTransition(resName);
        };
        if (!type.compare("xml")) {
                return ACDDResource::getInstance()->getXml(resName);
        };
        return  0x0000;
};
