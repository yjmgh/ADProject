package com.offer.jianzhi.fivezhang;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Yjm
 * @create 2019-10-05 20:08
 */
//题目：找出数组中最小的K个数，P209
//思路：使用最大堆，堆的size是K,当堆没有满的时候，就可以一直往里面放，堆满的话就和最大值进行比较，最大值大的话删除最大值，插入该元素
    //最大值小的话忽略该元素
//伪代码：1 构建最大堆，size ，
//       2 for : 堆满？ 满 ：比较 处理 ， 不满 ：放
//       3 最后依次取出元素

public class MinKNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{4 , 5 , 1 , 6 ,2 ,7 , 3, 8};
        System.out.println(Arrays.toString(fun(arr, 4)));
    }

    public static int[] fun(int[] arr , int k) {
        if(arr == null || k <= 0 || arr.length < k) return null;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1 , o2) -> o2 - o1);
        int[] res = new int[k];
        int size = 0;

        for (int i = 0; i < arr.length; i++) {
            if(size < k) {
                maxHeap.offer(arr[i]);
                size++;
            }else {
                if(maxHeap.peek() > arr[i]){
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }

        //size 一定大于等于K
        int temp = 0;
        while(!maxHeap.isEmpty()){
            res[temp] = maxHeap.poll();
            temp++;
        }

        return res;
    }
}
