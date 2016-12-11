
#include "ACDDResourceImpl.h"
void acdd_parseResourceTable(){
        std::string sharedResourceSymbol=ACDDAaptConfig::getInstance()->getSharedResourcePath();
        if(access(sharedResourceSymbol.c_str(),F_OK)==-1) {
                fprintf(stderr, "PreDefine  Resource  Symbol file not access   ,process abort!!! \n");
                exit(-0x01010000);
        }else{
                fprintf(stderr, "PreDefine  Resource  Symbol  found \n");
                sp<XMLNode> root = XMLNode::parse(sharedResourceSymbol.c_str());

                Vector<sp<XMLNode> >mChildrenNodes= root->getChildren();
                for (size_t i=0; i<mChildrenNodes.size(); i++) {
                        sp<XMLNode> mCurrntNode=  mChildrenNodes.itemAt(i);

                        Vector<XMLNode::attribute_entry> mAttributes=mCurrntNode->getAttributes();
                        std::string type;
                        std::string name;
                        int value=0;
                        for (size_t i=0; i<mAttributes.size(); i++) {
                                const XMLNode::attribute_entry& ae(mAttributes.itemAt(i));

                                if(!ae.name.compare(android::String16("type"))) {
                                        type=  String8(ae.string).string();
                                }else if (!ae.name.compare(android::String16("name"))) {
                                        name=  String8(ae.string).string();
                                }else if(!ae.name.compare(android::String16("id"))) {
                                        value=   strtol(String8(ae.string).string(),NULL,16);
                                }
                        }
                        ACDDResourceBridge::getInstance()->addResourceSymbol(type,name,value);


                }

        }

}
