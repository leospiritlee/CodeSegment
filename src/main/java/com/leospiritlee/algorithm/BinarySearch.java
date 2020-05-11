package com.leospiritlee.algorithm;

/**
 * @Project: CodeSegment
 * @ClassName BinarySearch
 * @description: 二分查找
 * @author: leospiritlee
 * @create: 2020-05-11 21:24
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int arrays[] = new int[]{1,3,5,6,7,8,9,10,12,45,55};
        //-1
        System.out.println(binarySearch(arrays, 11));
        //8
        System.out.println(binarySearch(arrays, 12));
        //0
        System.out.println(binarySearch(arrays, 1));
        //3
        System.out.println(binarySearch(arrays, 6));
    }

    /**
     * 二分查找 返回数组下标
     * @param arrays
     * @param item
     * @return
     */
    public static int binarySearch(int[] arrays, int item){

        if(null == arrays || arrays.length == 0){
            System.out.println("arrays is blank");
            throw new NullPointerException();
        }


        int low = 0;
        int high = arrays.length - 1;

        while (low <= high){

            int mid = (low + high) / 2;
            int guess = arrays[mid];

            if(guess == item){
                return mid;
            }

            //猜的数字大了
            if(guess > item){
                high = mid - 1;
            }else{
                //猜的数字 小了
                low = mid + 1;
            }

        }

        return -1;
    }


}
