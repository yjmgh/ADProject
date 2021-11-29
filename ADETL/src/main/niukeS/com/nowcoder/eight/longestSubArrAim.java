package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-09-22 19:39
 */
//题目：给定一个数组arr，全是正数，一个整数aim 求累加和等于aim的，最长子数组，要求额外空间复杂度是O(1),时间复杂度O(n)
//空间复杂度是O(1)就没法用hashMap了，
// 使用窗口的话r往右走是递增的，l往右走是递减的 窗口扩展到xi之前 sum(窗口) < aim，窗口扩展到xi的时候
// 1 sum(窗口) = aim 与max比较
// 2 sum(窗口) < aim r右移 sum递增
// 3 sum(窗口) > aim 右移 sum相减
//一开始l==r==-1 sum=0
public class longestSubArrAim {
    public static void main(String[] args) {

    }

    public static int fun(int[] arr , int aim){
        if(arr == null || arr.length == 0) return 0;

        int l = 0;
        int r = 0;
        int sum = arr[0];
        int len = 1;
        int max = Integer.MIN_VALUE;
        //当r走到最后一个元素的位置
        // 窗口内有数  1 加上最后一个数 > aim l++ 2 加上最后一个数 < aim 窗口作废 加上最后一个数 = aim 比较max
        // 窗口内无数 r++ r == l == arr.length 退出去
        while(r < arr.length){
            if(sum == aim){
                max = Math.max(max , len);
                sum -= arr[l];
                l++;
                len--;
            }else if(sum < aim){
                r++;
                if(r == arr.length) break;
                sum += arr[r];
                len++;
            }else {
                sum -= arr[l];
                l++;
                len--;
            }
        }

        return max;
    }
}
