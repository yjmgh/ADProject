package com.offer.jianzhi.threezhang;

import java.util.Arrays;

/**
 * @author Yjm
 * @create 2019-09-28 21:35
 */
//题目: 设计一种模式 ：满足条件的放在数组的右边 ， 不满足条件的放在数组的左边
// 以奇数放在左边 ， 偶数放在右边为例 判断标准就是是不是偶数
//p1 指着第一个元素 ， p2指着最后一个元素
//p1 往右走找到第一个偶数元素 ， p2往左走找到第一个奇数元素，进行交换
//p1 == p2  跳出循环
public class tiaozhengshuzushunxu {
    public static void main(String[] args) {

        int[] arr = {1 ,2 ,3, 4 ,5 ,9 ,8 ,6};
        fun(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void fun(int[] arr){
        if(arr == null || arr.length == 0) return;

        int p1 = 0;
        int p2 = arr.length-1;

        while (p1 < p2){

            while (p1 < p2 && !isFlag(arr[p1] )){
                p1++;
            } //是奇数右走

            while (p1 < p2 && isFlag(arr[p2])){
                p2--;
            }

            if(p1 < p2){
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
            }
        }

    }

    public static boolean isFlag(int n){
        //return (n & 1 ) == 0;
        return (n % 3 ) == 0;
    }
}
