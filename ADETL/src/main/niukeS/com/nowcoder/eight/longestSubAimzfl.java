package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-09-22 20:14
 */
//题目:给定一个数组arr 值可正可负可0，一个整数aim，求累加和小于等于aim的最长子数组，要求时间复杂度为O(N)
//解题思路：肯定不能用hashmap了，因为会有很多值的
//创建一个数组，记录着当前位置能否向右扩，如果加上前面的值变小了就向又扩，另一个数组记录着能扩到的位置
//这样再使用窗口的话，就能做到时间复杂度是O(N)
//伪代码：创建两个数组arr1 arr2
// arr1记录：当前元素右扩的最小值 min(自己,自己+前一个)
// arr2记录：当前元素右扩的位置
//基于arr1 做窗口操作 返回max
public class longestSubAimzfl {
    public static void main(String[] args) {

    }
    public static int fun(int[] arr , int aim){
        if(arr == null || arr.length == 0) return 0;
        int[] arr1 = new int[arr.length];
        int[] arr2 = new int[arr.length];

        arr1[arr.length-1] = arr[arr.length-1];
        arr2[arr.length-1] = arr.length-1;

        for (int i = arr.length-2; i >= 0 ; i--) {
            if(arr1[i+1] <= 0){
                arr1[i] = arr1[i+1] + arr[i];//arr1[i]右扩后值变小
                arr2[i] = arr2[i+1];
            }else {
                arr1[i] = arr[i];
                arr2[i] = i;
            }
        }


        //构造好arr1 arr2后 就是窗口函数了
        //int l = 0;
        int r = 0;
        int sum = 0;
        int len = 0;
        int max = Integer.MIN_VALUE;
        //当r走到最后一个元素的位置
        // 窗口内有数  1 加上最后一个数 > aim l++ 2 加上最后一个数 < aim 窗口作废 加上最后一个数 = aim 比较max
        // 窗口内无数 r++ r == l == arr.length 退出去
        //计算出每个位置的最长数组
        for (int i = 0; i < arr.length; i++) {
            while(r  < arr.length && sum + arr1[r] <= aim){
                sum += arr1[r];
                r = arr2[r]+1;
            }
            sum -= r > i ? arr[i] : 0; //意思是r虽然指着第一个元素，但是窗口还没有扩进来窗口其实  这里的i就是l
            len = r - i;//len没有要r的地方，要的是r-1的地方
            max = Math.max(max , len);
            r = Math.max(r , i+1);//r>i时就是r r<=i 时 r = i+1;
        }

        return max;

    }
}
