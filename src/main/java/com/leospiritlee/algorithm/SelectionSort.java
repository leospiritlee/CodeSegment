package com.leospiritlee.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Project: CodeSegment
 * @ClassName SelectionSort
 * @description: 选择排序
 * @author: leospiritlee
 * @create: 2020-05-11 21:38
 **/
public class SelectionSort {


    public static void main(String[] args) {

        List<Integer> arrays = new ArrayList<>(Arrays.asList(11,33,25,6,17,58,19,100,12,45,55,1,9));

        System.out.println("before sort: " + arrays);
        selectionSort(arrays);
        System.out.println("after sort: " + arrays);

    }

    /**
     * 选择排序
     * @param arrays
     */
    public static void selectionSort(List<Integer> arrays){

        if(null == arrays || arrays.size() == 0){
            throw new NullPointerException();
        }

        //构建新集合
        List<Integer> newArrays = new ArrayList<>(arrays.size());

        for(int i = 0, len = arrays.size(); i < len; i++){
            int smallest_index = findSmallest(arrays);
            newArrays.add(arrays.remove(smallest_index));
        }

        arrays.addAll(newArrays);
    }

    /**
     *  寻找当前数组最小的元素
     * @param arrays
     */
    private static int findSmallest(List<Integer> arrays){
        int smallest_index = 0;
        int smallest = arrays.get(smallest_index);


        for(int i = 0, len = arrays.size(); i < len; i++){
            if(arrays.get(i) < smallest){
                smallest = arrays.get(i);
                smallest_index = i;
            }
        }

        return smallest_index;
    }

}
