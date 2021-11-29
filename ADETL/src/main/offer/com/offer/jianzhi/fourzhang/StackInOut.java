package com.offer.jianzhi.fourzhang;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-10-03 15:25
 */
//题目 ：给出一个入栈序列，判断出栈序列是否是对的，例如：入栈 { 1 , 2 , 3 , 4 , 5 }，出栈为 { 4 , 5 , 3 , 2 , 1 }是正确的
// { 4 , 3 , 5 , 1 , 2 }就是错误的
//思路：先将第一个元素及之前的元素 压入栈 ， 之后遇到与栈顶相同的元素则弹出 ， 大于栈顶的元素则将该元素及之前的元素都压入栈，
//遇到小于栈顶的元素则报错
public class StackInOut {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] bidui = new int[]{4, 5, 3, 2, 1};
        int[] temp = new int[]{4, 3 , 5, 1, 2};

        System.out.println(fun(arr, temp));
    }
    public static boolean fun(int[] arr , int[] bidui){
        if(arr == null || arr.length == 0 || bidui == null || bidui.length == 0) return false;

        return process(arr , bidui);
    }

    public static boolean process(int[] arr , int[] bidui){

        HashMap<Integer , Integer> map = new HashMap<>();    //保证在O(1)时间找到bidui的元素再arr中的位置 ，值 -- 位置
        HashMap<Integer , Integer> map_in = new HashMap<>(); //已经进过栈的元素 值 -- 位置
        Stack<Integer> stack =new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i] , i);
        }

        //先将第一个元素及之前的元素 压入栈

        int temp = map.get(bidui[0]);
        for (int i = 0; i <= temp; i++) {
            stack.push(i);
            map_in.put(arr[i] , i);
        }


        for (int i = 0; i < bidui.length; i++) {
            //栈中最高位置
            int j = stack.peek();
            //找到4所在的位置
            int bidui_arr = map.get(bidui[i]);

            if(j == bidui_arr){
                stack.pop();
            }else if(j < bidui_arr){ //不包含bidui_arr
                for (int k = j+1; k < bidui_arr; k++) { //有个问题4弹出后再给压回来怎么解决
                    if(!map_in.containsKey(arr[k])){
                        stack.push(k);
                        map_in.put(arr[k] , k);
                    }
                }
            }else {
                return false;
            }
        }

        if(stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
