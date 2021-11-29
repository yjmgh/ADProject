package com.offer.jianzhi.one;

import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-09-25 9:43
 */
/*
题目：给有一个数组，找出一个元素，元素左边的所有元素都比他小 ， 元素右边的所有元素都比他大
// 235416789 则是6
解题思路：使用栈 入栈的元素一定是左边都比他小的元素，左边有一个max，大于他才有机会入栈
1 来了一个元素 ， 栈空与max比较，大于直接就进
2 栈非空 ， 看是否大于栈顶元素 ， 大于的话 ， 进栈 ， 小于等于的话出栈， 栈空与max比较，大于直接就进

*/
public class zuoxiaoyouda {
    public static void main(String[] args) {

        int[] arr = new int[]{1,4,3,2,6 ,7 ,8};
        int[] a = getNumber(arr);
        if(a[0] == 0) {
            System.out.println("没有");
        }else {
            System.out.println(arr[a[1]]);
        }
    }

    public static int[] getNumber(int[] arr){
        if(arr == null || arr.length == 0) return new int[2];
        return fun(arr);

    }
    //arr已经至少有一个元素了
    public static int[] fun(int[] arr){
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                if(arr[i] > max){
                    stack.push(i);
                    max = arr[i];
                    break;
                }
            }else {
                stack.push(arr[i]);
                max = Math.max(max , arr[i]);
            }


        }

        if(stack.isEmpty()) return new int[]{0 , 0};
        //此时栈里的元素都满足
        while (stack.size() > 1) stack.pop();
        return new int[]{1 , arr[stack.pop()]};
    }
}
