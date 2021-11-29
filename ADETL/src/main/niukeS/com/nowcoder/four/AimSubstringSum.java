package com.nowcoder.four;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-09-14 15:11
 */
//在给定的数组中找出一个最长的子数组，子数组中元素和等于aim
//遇到子数组的问题基本上就是0 -- i求 以i结尾的子数组发生的事
//遇到求多个子数组的话i就从后往前走
//解法：当前位置为i，0 -- i的和sum(i),看看是否存在sum(i) - aim的位置，若有和max比较
//若aim == 800 那么：
// sum(i) == 2000 找是否有sum(x) == 1200,若有的话 sum(x+1 -- i) == 800
public class AimSubstringSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,7,-3,-2,-1,0};
        System.out.println(fun(arr,7));
    }

    public static int fun(int[] arr , int aim){
        if(arr == null || arr.length==0) return -1;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();//<sum , position>
        map.put(0 , -1);
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum - aim)){
                maxlen = Math.max(i - map.get(sum - aim),maxlen);
            }
            if(!map.containsKey(sum)){
                map.put(sum , i);
            }
        }
        return maxlen;


    }
}
