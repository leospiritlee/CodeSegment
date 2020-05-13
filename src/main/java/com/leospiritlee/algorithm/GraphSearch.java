package com.leospiritlee.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Project: CodeSegment
 * @ClassName GraphSearch
 * @description: 图的广度搜索查找
 * @author: leospiritlee
 * @create: 2020-05-13 14:54
 **/
public class GraphSearch {

    /**
     *  一级数据
     */
    static List<String> firstList = new ArrayList<>();

    /**
     *  二级数据
     */
    static Map<String, List<String>> secondMap = new HashMap<>();


    /**
     *  静态方法块 初始化测试数据
     */
    static {

        firstList.add("Angel");
        firstList.add("Bill");
        firstList.add("Candy");


        List<String> secondList_1 = new ArrayList<>();
        secondList_1.add("Tom");
        secondList_1.add("Jerry");
        secondMap.put("Angel", secondList_1);

        List<String> secondList_2 = new ArrayList<>();
        secondList_2.add("Coke");
        secondList_2.add("Apply");
        secondMap.put("Bill", secondList_2);

        List<String> secondList_3 = new ArrayList<>();
        secondList_3.add("Jim");
        secondMap.put("Candy", secondList_3);

    }


    public static void main(String[] args) {
        graph_search();
    }


    /**
     *  初始化队列 双端队列
     *  一级数据先入队列
     *      判断是否满足条件
     *          满足 结束 输出满足结果
     *          不满足  一级数据对应二级数据放入队列
     * @return
     */
    public static String graph_search(){

        Deque<String> deque = new LinkedList<>();

        List<String> searched = new ArrayList<>();
        //一级数据入队
        deque.addAll(firstList);

        while (!deque.isEmpty()){
            //FIFO 从头部获取数据
            String name = deque.pop();

            //已经检查过了
            if(searched.contains(name)){
                continue;
            }

            if(isMatch(name)){
                System.out.println("find the name : " + name);
                System.out.println(deque.toString());
                return name;
            }

            //不满足match条件 一级数据对应二级数据放入队列
            if(secondMap.get(name) != null){
                deque.addAll(secondMap.get(name));
                searched.add(name);
            }
        }

        return null;
    }

    /**
     *  是否匹配
     * @param name
     * @return
     */
    private static boolean isMatch(String name){
        if(null != name && name.endsWith("m")){
            return true;
        }

        return false;
    }

}
