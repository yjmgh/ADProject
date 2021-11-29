package com.nowcoder.four;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-09-14 15:50
 */
//题目：找出给定数组中异或为0的子数组个数最多的划分，子数组之间不重合
//解：假设有一个最佳的划分：最优一个子数组有两种情况：1 异或等于0， 2 异或不等于0
//1 的情况 k -- i是最后一组，找倒数第二组再进行判断
//2 的情况 last 跟last-1的情况是一样的，就是有没有last都无所谓，不影响异或为0的数量
//max(dp[i - 1] , dp[k]+1)
//解释：
    // 三种情况：k x x x i 没有找到sum(k) == sum(i)的情况 dp[i - 1]  x x x 异或不等于0
    //          k x x x sum(i) == sum(k) 的情况 dp[k]+1
    //          k 0 0 0 sum(i) == sum(k) 的情况 dp[i - 1]
public class MostEOR {
    public static void main(String[] args) {
        int[] arr = new int[]{1 , 2 , 3};
        System.out.println(fun(arr));
    }

    public static int fun(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int res = 0;
        int xorSum = 0; // n or n == 0 ; n or 0 == n
        int[] mosts = new int[arr.length];//记录每个节点的最多异或为0的子数组的个数
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);//问题：第一个元素怎么放  (position , xorSum) -- (-1 ,0) ;0 or n == n是前提
        for (int i = 0; i < arr.length; i++) {
            xorSum ^= arr[i];
            if(map.containsKey(xorSum)){
                int k = map.get(xorSum);
                mosts[i] = k == -1  ? 1 : (mosts[k] + 1);// k == -1的情况肯定是xorSum == 0 的情况
            }
            if(i > 0){
                mosts[i] = Math.max(mosts[i - 1],mosts[i]);//mosts[i]加上i最后一个是异或等于0的情况
                                                           //mosts[i - 1] 是 k 0 0 i这种情况
            }
            map.put(xorSum, i);//mosts[0]本身就是0
            res = Math.max(res , mosts[i]);//觉得res就没必要了
        }
        return res;
    }

}
