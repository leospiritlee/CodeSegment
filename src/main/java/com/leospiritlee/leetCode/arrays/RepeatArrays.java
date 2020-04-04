package com.leospiritlee.leetCode.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Project: CodeSegment
 * @ClassName RepeatArrays
 * @description:
 *  找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个
 * 重复的数字。
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *  2 <= n <= 100000
 *
 * @author: leospiritlee
 * @create: 2020-04-04 17:42
 **/
public class RepeatArrays {

    public static void main(String[] args) {
        RepeatArrays repeatArrays = new RepeatArrays();
        repeatArrays.findRepeatNumber();
    }


    /**
     *  查询重复数字
     */
    private void findRepeatNumber(){
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};

        this.solution1(nums);

        this.solution2(nums);

        this.solution3(nums);
    }

    /**
     * 思路1
     * 通过hashSet 获取重复数据
     * @param nums
     */
    private void solution1(int[] nums){

        //重复数据保存列表
        List<Integer> repeatNumsList = new ArrayList<>();
        //set key 唯一 添加失败即为重复
        Set<Integer> numsSet = new HashSet<>();

        for(int num : nums){
            if(!numsSet.add(num)){
                //set add 失败 即为重复数据
                repeatNumsList.add(num);
            }
        }

        System.out.println(repeatNumsList);
    }


    /**
     * 思路2
     * 此处使用nums 数组本身做 hash处理
     * 将每个位置的数交换映射到其对应的数组下标下面，
     * 当出现新的元素与其对应的下标中的数字相等时，即为重复数字
     *
     *
     *
     * @param nums
     */
    private void solution2(int[] nums){

        //重复数据保存列表
        List<Integer> repeatNumsList = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            /**
             * {2, 3, 1, 0, 2, 5, 3}
             *
             * i = 0
             *      while nums[i] = 2  != 0
             *          if 2 ==  nums[2] 1 两个相等即为重复
             *             交换位置
             *          temp = 2;
             *          nums[0] = nums[2] = 1
             *          nums[2] = 2
             *  i = 1
             *        while nums[i] = 3  != 1
             *            if 3 ==  nums[3] 0 两个相等即为重复
             *                 交换位置
             *              temp = 3;
             *              nums[1] = nums[3] = 3
             *              nums[3] = 3
             *
             *   i = 2
             *        while nums[i] = 1  != 3
             *             if 1 ==  nums[3] 2 两个相等即为重复
             *              交换位置
             *              temp = 1;
             *              nums[2] = nums[1] = 3
             *              nums[1] = 3
             */

            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    repeatNumsList.add(nums[i]);
                    //需要跳出本次循环
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        System.out.println(repeatNumsList);
    }

    /**
     * 思路3
     *  此处增加hashMap 用来做计数器 value > 1 的key 即为重复
     * @param nums
     */
    private void solution3(int[] nums){
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            if (countMap.containsKey(num) == false) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        countMap.forEach((k, v)->{
            if(v > 1){
                System.out.println(k);
            }
        });
    }
}
