package com.leospiritlee.util;

import com.leospiritlee.strategy.annotation.HandlerType;
import com.leospiritlee.strategy.handler.AbstractHandler;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Handler;

/**
 * @Project: CodeSegment
 * @ClassName ClassLoadUtil
 * @description: 类加载工具类
 * @author: leospiritlee
 * @create: 2020-03-19 23:19
 **/
public class ClassLoadUtil {

    private final static String PROTOCOL_FILE = "file";

    private final static String PROTOCOL_JAR = "jar";

    private static final String CLASS_SUFFIX = ".class";

    private static final String CLASS_FILE_PREFIX = File.separator + "classes"  + File.separator;

    private static final String PACKAGE_SEPARATOR = ".";


    public static void main(String[] args) {
        boolean showChildPackageFlag = false;
        String packName = "com.leospiritlee.strategy.handler";
        List<String> resultList = getClazzName(packName, showChildPackageFlag);
        resultList.stream().forEach(System.out::println);
    }

    /**
     * 通过包名加载包名下所有文件名称
     * @param packageName
     * @param showChildPackageFlag
     * @return
     */
    public static List<String> getClazzName(String packageName, boolean showChildPackageFlag ){
        List<String> resultList = new ArrayList<>();
        String suffixPath = packageName.replace(".","/");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Enumeration<URL> urls = loader.getResources(suffixPath);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if(null != url){
                    String protocol = url.getProtocol();

                    if(PROTOCOL_FILE.equals(protocol)){
                        String path = url.getPath();
//                        System.out.println(path);
                        resultList.addAll(getAllClassNameFromFile(new File(path), showChildPackageFlag));
                    }else if(PROTOCOL_JAR.equals(protocol)){
                        JarFile jarFile = null;
                        try{
                            jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
                        } catch(Exception e){
                            e.printStackTrace(System.err);
                        }
                        if(jarFile != null) {
                            resultList.addAll(getAllClassNameFromJar(jarFile, packageName, showChildPackageFlag));
                        }
                    }

                }
            }

        }catch (IOException e){
            e.printStackTrace(System.err);
        }

        fillResultList(resultList, packageName);

        return resultList;
    }


    /**
     * 递归获取所有class文件的名字
     * @param file file文件
     * @param flag 是否需要迭代遍历
     * @return
     */
    private static List<String> getAllClassNameFromFile(File file, boolean flag){
        List<String> resultList = new ArrayList<>();

        if(!file.exists()){
            return resultList;
        }

        if(file.isFile()){
            setClazzName(file.getPath(), resultList);

            //文件夹递归需要返回
            return resultList;
        }else{
            File[] listFiles = file.listFiles();
            if(null != listFiles && listFiles.length > 0){
                for(File f : listFiles){
                    if(flag){
                        resultList.addAll(getAllClassNameFromFile(f, flag));
                    }else{
                        setClazzName(f.getPath(), resultList);
                    }
                }
            }
        }
        return resultList;
    }

    /**
     *  设置clazzName
     * @param path
     * @param resultList
     */
    private static void setClazzName(String path, List<String> resultList){
        if(path.endsWith(CLASS_SUFFIX)){
            path = path.replace(CLASS_SUFFIX, "");
            // 从"/classes/"后面开始截取
            String clazzName =
                    path.substring(path.indexOf(CLASS_FILE_PREFIX) + CLASS_FILE_PREFIX.length())
                            .replace(File.separator, PACKAGE_SEPARATOR);

            if(-1 == clazzName.indexOf("$")){
                resultList.add(clazzName.substring(clazzName.lastIndexOf(PACKAGE_SEPARATOR) ));
            }
        }
    }

    /**
     * 填充resultList
     * @param resultList
     * @param packageName
     */
    private static void fillResultList(List<String> resultList, String packageName){

        for(int i = 0, size = resultList.size(); i < size; i++){
            resultList.set(i, packageName.concat(resultList.get(i)));
        }
    }


    /**
     * 递归获取所有class文件的名字
     * @param jarFile jar文件
     * @param packageName 包名
     * @param flag 是否需要迭代遍历
     * @return
     */
    private static List<String> getAllClassNameFromJar(JarFile jarFile, String packageName, boolean flag){
        List<String> resultList = new ArrayList<>();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()){
            JarEntry jarEntry = entries.nextElement();
            String name = jarEntry.getName();

            if(name.endsWith(CLASS_SUFFIX)){
                name = name.replace(CLASS_SUFFIX, "").replace("/",".");
                if(flag){
                    // 如果要子包的文件,那么就只要开头相同且不是内部类就ok
                    if(name.startsWith(packageName) && -1 == name.indexOf("$")) {
                        resultList.add(name);
                    }
                }else {
                    // 如果不要子包的文件,那么就必须保证最后一个"."之前的字符串和包名一样且不是内部类
                    if(packageName.equals(name.substring(0, name.lastIndexOf("."))) && -1 == name.indexOf("$")) {
                        resultList.add(name);
                    }
                }
            }

        }


        return resultList;
    }



}
