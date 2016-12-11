#ifndef __ACDDResourceBridge__
#define __ACDDResourceBridge__
#include <sstream>
#include <iostream>
#include <vector>
#include <string>


#include "ACDDResource.h"
using namespace std;
class ACDDResourceBridge {

public:
        static ACDDResourceBridge* getInstance()
        {
                static ACDDResourceBridge instance;
                return &instance;
        }
        int  getResourceId(std::string type,std::string resName);
        void addResourceSymbol(std::string type,std::string resName,int value);

protected:
        struct Object_Creator
        {
                Object_Creator()
                {
                        ACDDResourceBridge::getInstance();
                }
        };
        static Object_Creator _object_creator;

        ACDDResourceBridge(){
        };
        ~ACDDResourceBridge() {
        }
};

#endif
