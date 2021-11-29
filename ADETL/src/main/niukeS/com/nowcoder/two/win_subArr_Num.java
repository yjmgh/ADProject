package com.nowcoder.two;

import java.util.LinkedList;

/**
 * @author Yjm
 * @create 2019-09-08 22:13
 */
//最大值减去最小值小于或等于num的子数组数量【题目】
//给定数组arr和整数num，共返回有多少个子数组满足如下情况：
//max（arr【i..j】）-min（arr【i..j】）<=num
// max（arr【i..j】）表示子数组arr【i..j】中的最大值，min（arr【i.j】）表示子数组arr【i..j】中的最小值。
//【要求】
//如果数组长度为N，请实现时间复杂度为0（N）的解法。
public class win_subArr_Num {
    public static void main(String[] args) {
        int[] arr = new int[]{6 , 5 , 4 , 1};
        System.out.println(getSubArrNumber(arr,3));

    }
    public static int getSubArrNumber(int[] arr , int num){
        //使用两个双向链表分别记录窗口内最大值最小值
        LinkedList<Integer> qmin = new LinkedList<>(); // 必须是 [ 最小值，次小值 ，三小值 , ...]的情况，目的就是最大值没有更新的情况下，次大值能够接位
        LinkedList<Integer> qmax = new LinkedList<>(); // 必须是 [ 最大值，次大值 ，三大值 , ...]的情况

        int L = 0;
        int R = 0;
        int res = 0;

        while(L < arr.length){

            while(R < arr.length){
                //arr[R] <= max && arr[R] >= min 在里面
                //arr[R] > max : 1  arr[R] - min <= number 替换max R++ , 2 L++
                //arr[R] < min : 1  max - arr[R] <= number 替换min R++ , 2 L++
                //更新min
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]){
                    qmin.pollLast();
                }
                qmin.offerLast(R);

                //更新max
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]){ //此处有问题
                    qmax.pollLast();
                }
                qmax.offerLast(R);

                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) break;

                R++;
            }
            //qmin跟新了 看看最小值的下标过期了没有
            //[1 2 3 5] num = 3的情况
            if(qmin.peekFirst() == L){
                qmin.pollFirst();
            }
            //qmax更新了 看看最大值的下标过期了没有
            //例如 [6 , 5 , 4 , 1] num = 3的情况 因为L要忘下走，此时最大值会改变，适用于R走到结尾的情况
            if(qmax.peekFirst() == L){
                qmax.pollFirst();
            }


            res += R - L;
            L++;
        }

        return res;
    }
}
