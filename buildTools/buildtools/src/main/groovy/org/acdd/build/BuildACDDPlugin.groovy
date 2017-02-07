package org.acdd.build

import org.acdd.ext.bundleInfo.maker.BundleMakeBooter
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by Ino on 2017/2/5.
 */
public class BuildACDDPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        project.task("acddPluginBuildTask") <<{
            String[] args = new String[3];
            args[0] = "${project.projectDir}/libs/armeabi".toString();
            args[1] = "${project.projectDir}\\assets\\bundle-info.json".toString();
            args[2] = "${project.projectDir}/.bundleCache".toString();

//            println "apkFile: " + args[0]
//            println "jsonPath: " + args[1]
//            println "cacheFile: " + args[2]

            BundleMakeBooter.main(args)
        }
    }
}