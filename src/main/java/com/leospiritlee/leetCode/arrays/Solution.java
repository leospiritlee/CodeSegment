package com.leospiritlee.leetCode.arrays;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

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

        int[] nums1 = new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] nums2 = new int[]{2,42,38,0,43,21};
        int[] index = new int[]{2, 7, 11, 15};
        int target1 = 9;

        String[] arrayS = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
//        System.out.println(Arrays.toString(solution.createTargetArray(nums,index)));
//        System.out.println(relativeSortArray(nums1, nums2));
//        merge(nums1,3,nums2,3);
//        System.out.println(Arrays.toString(sumZero(4)));
        System.out.println(Arrays.toString(twoSum(index, target1)));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            if(map.put(nums[right],right)!=null){
                return true;
            }
            if(map.size()>k){
                map.remove(nums[right-k]);
            }
        }
        return false;

    }


    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null){
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }


    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
                if(map.get(num) > 1){
                    return true;
                }

            }else {
                map.put(num, 1);
            }
        }


        return false;
    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }



    public static int maxSubArray(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            int max = arr[i-1];
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
            arr[i] = max;
            maxSum = Math.max(maxSum, max);
        }
        return maxSum;
    }



    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int tmpCompare = 0;
        for(int num : nums){
            if(num == 1){
                count ++;
            }else{
                if(tmpCompare == 0){
                    tmpCompare = count;
                }else{
                    if(count > tmpCompare){
                        tmpCompare = count;
                        count = 0;
                    }
                }
                count = 0;
            }
        }

        return count > tmpCompare ? count : tmpCompare;
    }


    public int search(int[] nums, int target) {
        int count = 0;
        for(int num : nums){
            if(num == target){
                count++;
            }
        }
        return count;
    }

    public int missingNumber(int[] nums) {
        int a = 1;
        int b = nums.length;
        int sum = (a+b) * (b-a+1) / 2;

        int numsSum = 0;
        for(int num : nums){
            numsSum += num;
        }

        return sum - numsSum;
    }



    public static int fib(int N) {
        if(N == 0 || N ==1){
            return N;
        }

        int[] numArray = new int[N+1];
        numArray[0] = 0;
        numArray[1] = 1;
        for(int i = 2; i < N + 1; i++){
            numArray[i] = numArray[i-1] + numArray[i-2];
        }



        return numArray[N];
    }


    public static int countCharacters(String[] words, String chars) {

        int sum = 0;
        for(String word : words){
            boolean flag = true;
            String[] wordArray = word.split("");
            for(int i = 0; i < wordArray.length; i++){
                if(chars.indexOf(wordArray[i]) < 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sum += word.length();
            }

        }

        return sum;
    }

    public static int[] sumZero(int n) {

        int[] result = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(i == n -1){
                result[i] = 0-sum;
                break;
            }
            result[i] = i ;
            sum +=i;
        }


        return result;
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        long y = year;
        long m = month;
        long total = 0;
        total += 365 * y;
        if (y >= 0) {
            total += (y + 3) / 4 - (y + 99) / 100 + (y + 399) / 400;
        } else {
            total -= y / -4 - y / -100 + y / -400;
        }
        total += ((367 * m - 362) / 12);
        total += day - 1;
        if (m > 2) {
            total--;
            if (isLeapYear(y) == false) {
                total--;
            }
        }
        total =  total - ((146097 * 5L) - (30L * 365L + 7L));


        int dow0 = (int)Math.floorMod(total + 3, 7) + 1;

        switch (dow0){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "";
        }

    }


    public static boolean isLeapYear(long prolepticYear) {
        return ((prolepticYear & 3) == 0) && ((prolepticYear % 100) != 0 || (prolepticYear % 400) == 0);
    }

    public int findSpecialInteger(int[] arr) {

        int threshold = arr.length / 4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i + threshold] == arr[i]) {
                return arr[i];
            }
        }
        return 0;
    }


    public void moveZeroes(int[] nums) {
       if(nums == null){
           return;
       }

       int j = 0;
       for(int num : nums){
           if(num != 0){
               nums[j++] = num;
           }
       }

       while (j < nums.length){
           nums[j++] = 0;
       }

    }



    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length];
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for(int num : arr1){
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num) + 1);
            }else {
                countMap.put(num, 1);
            }
        }

        System.out.println(countMap);

        int tmpIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            int tmp = arr2[i];
            int count = countMap.get(tmp) == null ? 1 : countMap.remove(tmp);
            for (int j = 0; j < count; j++) {
                newArray[tmpIndex] = tmp;
                tmpIndex++;
            }
        }

        if(countMap.size() > 0){
            for(int k : countMap.keySet()){
                int v  = countMap.get(k);
               for(int m = 0; m <v; m++){
                   newArray[tmpIndex] = k;
                   tmpIndex++;
               }
            }
        }


        return newArray;
    }


    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int len = nums.length /2;

        for(int num : nums){
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num) + 1);
            }else {
                countMap.put(num, 1);
            }
        }

        for(Integer k : countMap.keySet()){
            if(countMap.get(k) > len){
                return k;
            }
        }


        return -1;
    }

    public void merge_1(int[] A, int m, int[] B, int n) {
        System.arraycopy(B,0, A, m, n);
        Arrays.sort(A);
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }


    public int[] sortedSquares(int[] A) {

        for(int i = 0, size = A.length; i < size; i++){
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);

        return A;
    }


    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) {
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>();
        occurred.add(head.val);
        ListNode pos = head;
        // 枚举前驱节点
        while (pos.next != null) {
            // 当前待删除节点
            ListNode cur = pos.next;
            if (occurred.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }


    public int[] sortArrayByParityII(int[] A) {

        int length = A.length;
        int[] newArray = new int[length];

        int k = 0;
        int m = 1;
        for(int a : A){

            if(a % 2 ==0){
                newArray[k] = a;
                k+=2;
            }else if(a % 2 == 1){
                newArray[m] = a;
                m+=2;
            }
        }


        return newArray;
    }


    public int xorOperation(int n, int start) {
        int sum = 0;
        while (start < n){
            start++;
            sum  =(start + 2 * start);
        }
        return sum;
    }

    public int[] runningSum(int[] nums) {

        for(int i = 1, size = nums.length; i < size; i++){
            nums[i] += nums[i-1];
        }

        return nums;
    }


    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }


    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i = 0; i < numRows; i++){
            List<Integer> array = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    array.add(1);
                }else{
                    array.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(array);
        }
        return ans;

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null){
            if(current.next.val == current.val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        int leftGain = Math.max(maxGain(treeNode.left), 0);
        int rightGain = Math.max(maxGain(treeNode.right), 0);

        int newValue = treeNode.val + leftGain + rightGain;
        maxSum = Math.max(newValue , maxSum);

        return treeNode.val + Math.max(leftGain, rightGain);
    }

    public int[] reversePrint(ListNode head) {
        ListNode current = head;
        int len = 0;
        while (current != null){
            len++;
            current = current.next;
        }

        int[] nums = new int[len];

        current = head;
        while (current != null){
            nums[len -1] = current.val;
            len--;
            current = current.next;
        }

        return nums;
    }

    public int maximum69Number (int num) {

        String beginS = String.valueOf(num).replaceFirst("6", "9");

        return Integer.parseInt(beginS);
    }



    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return  t1;
        }

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }



    public int kthToLast_(ListNode head, int k) {
        ListNode p = head;
        for(int i = 0; i < k; i++){
            p =p.next;
        }

        while (p != null){
            p = p.next;
            head = head.next;
        }

        return head.val;
    }


    public int kthToLast(ListNode head, int k) {
        List<Integer> headList = new ArrayList<>();

        while (head != null){
            headList.add(head.val);
            head = head.next;
        }

        return headList.get(headList.size()-k);
    }


    public static int balancedStringSplit(String s) {
        int cnt = 0;
        int poise = 0;

        char[] arrayC = s.toCharArray();

        for(char c : arrayC){
           switch (c){
               case 'L':
                   poise--;
                   break;
               case 'R':
                   poise++;
                   break;
               default:
                   break;
           }

           if(poise == 0){
               cnt++;
           }

        }


        return cnt;
    }


    public static int maxProduct(int[] nums) {
        int size = nums.length;
        int firstNum = nums[0];
        int secondNum = nums[1];

        for(int i = 2; i < size; i++){
            if(firstNum > secondNum){
                if(nums[i] > secondNum){
                    secondNum = nums[i];
                }
            }else{
                if(nums[i] > firstNum){
                    firstNum = nums[i];
                }
            }
        }


        return (firstNum -1) * (secondNum -1);
    }


    public int getDecimalValue(ListNode head) {

        if(head == null){
            return 0;
        }
        int decimal = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (head != null){
            stringBuilder.append(head.val);
            decimal = decimal * 2 + head.val;
            head = head.next;
        }

        System.out.println(decimal);

        return (int) Long.parseLong(stringBuilder.toString() , 2);
    }



    /**
     *  0  0
     *  1  1
     *  2  11
     *  3  111
     *  4  1111
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {


        if(n == 0){
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        int i = 1;

        while (i <= n){
            stringBuilder.append(1);
            i++;
        }

        Integer tmpIn = Integer.valueOf(stringBuilder.toString());

        int size = tmpIn * 9;

        int[] nums = new int[size];

        for(int k = 0; k < size; k++){
            nums[k] = k + 1;
        }

        return nums;
    }


    public int minCount(int[] coins) {

        if(null == coins){
            return 0;
        }

        int total = 0;

        for(int coin : coins){
            if(coin % 2 ==0){
                total += coin/2;
            }else{
                total += coin/2 +1;
            }
        }

        return total;
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void deleteNode_(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
