package com.offer.jianzhi.fivezhang;

/**
 * @author Yjm
 * @create 2019-10-05 19:51
 */
//题目：数组中出现次数超过一半的数字
//思路：使用一个变量记录一个数字 ， 当遇到下一个数字的时候，如果与该数字相同就++，若不同--，
// 因为该数字超过了一半，所以最后变量里面存的数字一定是它
// 伪代码：1 声明变量 val ，size
//        2 if(size > 0){ 相同 size++ ， 不同--} else{ val = cur , size = 1}
//        3 返回val
public class ChaoGuoYiBan {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5 , 8 , 1 ,5 , 1,1};
        System.out.println(fun(arr));
    }
    //保证arr不为null&&长度>0
    public static int fun(int[] arr){
        //if(arr == null || arr.length == 0)

        int val = arr[0];
        int size = 0;

        for (int i = 1; i < arr.length; i++) {
            if(size == 0){
                val = arr[i];
                size = 1;
            }else {
                if(val == arr[i]){
                    size++;
                }else {
                    size--;
                }
            }
        }

        return val;
    }
}
