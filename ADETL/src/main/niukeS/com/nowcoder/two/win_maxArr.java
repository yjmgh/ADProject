package com.nowcoder.two;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Yjm
 * @create 2019-09-08 23:32
 */
//生成窗口最大值数组
// 【题目】
//有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
//例如，数组为【4,3,5,4,3,3,6,7】，窗口大小为3时：
//【 4 3 5 】 4 3 3 6 7窗口中最大值为5
// 4【 3 5 4】  3 3 6 7窗口中最大值为5
// 4 3【 5 4 3】  3 6 7窗口中最大值为5
// 4 3 5【 4 3 3 】 6 7窗口中最大值为4
// 4 3 5 4【 3 3 6】 7窗口中最大值为6
// 4 3 5 4 3【 3 6 7】窗口中最大值为7
//如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
//请实现一个函数。
//输入：整型数组arr，窗口大小为w。
//输出：一个长度为n-w+1的数组res，res【i】表示每一种窗口状态下的最大值
//以上面数组为例，结果应该返回【5，5，5，4，6，7】。
public class win_maxArr {
    public static void main(String[] args ) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int[] res = fun(arr , 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] fun(int[] arr , int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {

            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i] ){
                qmax.pollLast();
            }
            qmax.offerLast(i);
            //判断过没过期 1 2 3 4
            //            0 1 2 3 当前元素是arr[3] 判断的是 arr[0]过没过期
            if(qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }

            if(i >= w-1){
                res[index] = arr[qmax.peekFirst()];
                index++;
            }

        }
        return res;

    }
}
