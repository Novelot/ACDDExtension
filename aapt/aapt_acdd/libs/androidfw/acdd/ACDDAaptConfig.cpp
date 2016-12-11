#include <androidfw/acdd/ACDDAaptConfig.h>
#include <androidfw/acdd/ACDDResourceBridge.h>

#include <iostream>
#include <string>
using namespace std;

ACDDAaptConfig::Object_Creator ACDDAaptConfig::_object_creator;

std::string inline delSpaces(std::string &str)
{
        for (size_t i = 0; i < str.length(); i++) {
                if (str[i] == ' ' || str[i] == '\n' || str[i] == '\t') {
                        str.erase(i, 1);
                        i--;
                }
        }
        return str;
}



bool ACDDAaptConfig::initACDDConig(std::string config,int configType){

        fprintf(stdout, "***ACDD*** initACDDConig %s \n",config.c_str());
        if (configType==ACDD_AAPT_CONFIG_TYPE_PACKAGE_GROUP_ID) {
                const char * pkgGroup=config.c_str();
                fprintf(stderr, "***ACDD*** ACDD Shared Resource pkgGroup %s \n",pkgGroup);
                if(pkgGroup[0]=='0'&&pkgGroup[1]=='x') {
                        packageGroupId=strtol(pkgGroup,NULL,16);
                }
        }else if (configType==ACDD_AAPT_CONFIG_TYPE_SHARED_RESOURCE_TABLE) {
                mSharedResourcePath=config;
        }
        return true;
}
std::string ACDDAaptConfig::getSharedResourcePackageName(){

        return mSharedResourcePackageName;
}
std::string ACDDAaptConfig::getSharedResourcePath(){

        return mSharedResourcePath;
}
size_t ACDDAaptConfig::getPackageGroupId(){
        return packageGroupId;


}
bool ACDDAaptConfig::isUpdateVersion(){
        return updateVersion;
}
std::string ACDDAaptConfig::getVersionName(){

        return versionName;
}
int ACDDAaptConfig::getSharedResource(std::string type,std::string name){

        return ACDDResourceBridge::getInstance()->getResourceId(type,name);;


}
