package com.leospiritlee.leetCode.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @Project: CodeSegment
 * @ClassName Solution
 * @description: TODO
 * @author: leospiritlee
 * @create: 2020-06-11 14:49
 **/
public class Solution {

    public static void main(String[] args) {
       int[] n = new int[]{2,3,5};int target = 10;
//       System.out.println(Arrays.toString(smallerNumbersThanCurrent(n)));

        Solution solution = new Solution();

//        System.out.println(solution.findBestValue(n, target));

        int[] nums = new int[]{1};
        int[] index = new int[]{0};

        System.out.println(Arrays.toString(solution.createTargetArray(nums,index)));

    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int target[] = new int[nums.length];

        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0, size = nums.length; i < size; i++){
//            if(linkedList.size() > index[i] && linkedList.get(index[i]) != null){
//                linkedList.add(index[i],nums[i]);
//            }else {
//                linkedList.add(nums[i]);
//            }
            linkedList.add(index[i],nums[i]);
        }

        for(int j = 0, size = linkedList.size(); j<size; j++){
            target[j] = linkedList.get(j);
        }


        return target;
    }


    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int average = target / length;
        int sum = 0, min = arr[0], max = arr[length - 1], index = -1, lSum = 0, tmp;
        // 最小值大于平均值时返回平均值
        if (min >= average) {
            int abs1 = Math.abs(average * length - target);
            int abs2 = Math.abs((average + 1) * length - target);
            if (abs1 > abs2) {
                return average + 1;
            }
            return average;
        }
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i];
            sum += tmp;
            if (tmp <= average) {
                // 记录左侧值
                lSum += tmp;
                index = i;
            }
        }
        if (sum <= target) {
            return max;
        }
        index++;
        int expected = target - lSum;
        for (int i = index; i < length; i++) {
            tmp = arr[i];
            // 剩余长度
            int rl = length - i;
            // 如果当前值*剩余长度大于expected, 说明value应小于当前值
            if (tmp * rl >= expected) {
                tmp = expected / rl;
                int abs1 = Math.abs(tmp * rl - expected);
                int abs2 = Math.abs((tmp + 1) * rl - expected);
                if (abs1 > abs2) {
                    return tmp + 1;
                }
                return tmp;
            }
            expected -= tmp;
        }
        return 0;
    }


    public int romanToInt(String s) {
        int sum = 0;
        int tmp = 0;
        char[] arrayC = s.toCharArray();
        int size = arrayC.length -1;
        for(int i=size; i>=0; i--){
            int num = this.getIntFromChar(arrayC[i]);
            if(num >= tmp){
                sum += num;
            }else{
                sum -= num;
            }

            tmp = num;
        }

        return sum;
    }


    private int getIntFromChar(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }



    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int numsLen = nums.length;

        int[] result = new int[numsLen];
        int count = 0;

        for(int i = 0; i < numsLen; i++){
            for(int j = 0; j < numsLen; j++){

                if(i == j){
                    continue;
                }

                if(nums[i] > nums[j]){
                    count++;
                }
            }

            result[i] = count;
            count = 0;
        }

        return result;
    }


    /**
     * 2
     *      1 1
     *      2
     * 3
     *      1 1  1
     *      1 2
     *      2 1
     * 4
     *      1 1 1 1
     *      1 1 2
     *      1 2 1
     *      2 1 1
     *      2 2
     * 5
     *      1 1 1 1 1
     *      1 1 1 2
     *      1 1 2 1
     *      1 2 1 1
     *      1 2 2
     *      2 1 1 1
     *      2 1 2
     *      2 2 1
     *  0  0
     *  1  1
     *  2  2
     *  3  3
     *  4  5
     *  5  8
     *  6 13
     *  7 21
     *
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        if(n <= 2){
            return n;
        }

        int k = 1;
        int j = 2;

        for(int i = 3; i<= n; i++){
            int tmp = k + j;
            k = j;
            j = tmp;
        }


        return j;
    }


    private int recursive(int n){
        if(n == 2 || n == 3){
            return n;
        }

        return  n-=1;
    }



    public static int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0, size = nums.length; i < size; i++){
            if(i % 2 > 0){
                for(int j = 1; j <= nums[i-1] ;j ++){
                    resultList.add(nums[i]);
                }
            }
        }

        int[] result = new int[resultList.size()];

        for(int i = 0, size = resultList.size(); i < size; i++){
            result[i] = resultList.get(i);
        }


        return result;
    }


    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums){
            if((n >= 10 && n< 100) || (n >=1000 && n < 10000) || n == 100000){
                count++;
            }
        }

        return count;
    }

    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }


    /**
     *  4423
     *      4 * 4 * 2 *3  - (4+ 4+ 2+3)
     * @param n
     * @return
     */
    public static int subtractProductAndSum(int n) {
        int sum = 0, mul = 1;
        while ( n> 0 ){
            //4 3 2
            int digit = n % 10;
            //23  2 0
            n /= 10;
            //4 7  9
            sum += digit;
            //4 12 24
            mul *= digit;
        }

        return mul -sum;
    }

    public static int numberOfSteps (int num) {
        int count = 0;

        while(num != 0){
            if(num % 2 == 0){
                num = num /2;

            }else{
                num = num -1;
            }
            count++;
        }


        return count;
    }

    private void calc(int num){



    }


    /**
     * [4 ,2, 1]
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int count=0,temp=0;
        for(int i = 0, len = nums.length -1; i < len; i++){
            if(nums[i]>nums[i+1]){
                if(count++>0){
                    return false;
                }
                if(nums[i+1]<temp){
                    nums[i+1]=nums[i];
                }else{
                    nums[i]=temp;
                }
            }
            temp=nums[i];
        }


        return true;
    }



    public static int numJewelsInStones(String J, String S) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0, size = S.length(); i< size; i++){
            char tmpS = S.charAt(i);
            if(map.get(tmpS) != null){
                map.put(tmpS, map.get(tmpS) + 1);
            }else {
                map.put(tmpS, 1);
            }
        }

        int count = 0;
        for(int i = 0, size = J.length(); i< size; i++){
            System.out.println(J.charAt(0));
            System.out.println(map.get(J.charAt(0)));
            if(map.get(J.charAt(i)) != null){
                count = count +  map.get(J.charAt(0));
            }
        }

        return count;
    }


    public int game(int[] guess, int[] answer) {

        int guessTime = 0;
       for(int i = 0; i < 3; i++){
           if(guess[i] == answer[i]){
               guessTime++;
           }
       }

        return guessTime;
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static String reverseLeftWords(String s, int n) {
       return s.substring(n) + s.substring(0,n);
    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int tmp = candies[0];

        for(int num : candies){
            if(num > tmp){
                tmp = num;
            }
        }

        for(int num : candies){
            if(num + extraCandies >= tmp){
                result.add(true);
            }else {
                result.add(false);
            }
        }

        return result;
    }

    /**
     * 2,5,1,3,4,7
     * 2,3,5,4,1,7
     * @param nums
     * @param n
     * @return
     */
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        int k = 1;
        for(int i = 0; i < nums.length; i++){
            if(2*i < nums.length){
                result[2*i] = nums[i];
                result[2*k -1] = nums[n];
                k++;
                n++;
            }
        }


        return result;
    }


    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }


}
