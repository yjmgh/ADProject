package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-08-28 21:37
 */
/*
* 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false
* 解题思路：第一个元素要不要选，第二个元素要不要选 .........
* 先写出暴力递归版本
* 之后改成动态规划
* ：1 满足条件：无后效性
* ：2 重复计算
* 构建二维数组  f(i,sum) = f(i+1)(sum + arr[i]) || f(i+1)(sum)
* 给f(arr.length,aim) = true
* */
public class ArrToAim {
    public static void main(String[] args) {

        int[] arr = {5 , 8 ,9 , 6};
        //System.out.println(fun_aim(arr,0,0,18));
        System.out.println(fun_aim_dp(arr,17));
    }

//暴力递归
    public static boolean fun_aim(int[] arr , int i ,int sum,int aim){
        if(i == arr.length){
            boolean f = (sum == aim)?true:false;
            return f;
        }
        boolean flag = fun_aim(arr,i+1,sum + arr[i],aim) || fun_aim(arr,i+1 , sum ,aim);//第一个是要，第二个是不要
        return flag;
    }
    //改成动态规划版本的
    public static boolean fun_aim_dp(int[] arr ,int aim){
        if(arr == null ) return  false;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if(aim > sum) return false;

        int t_r = arr.length+1;
        int t_c = sum + 1;
        boolean[][] temp = new boolean[t_r][t_c];//这个数组默认的值就是false
        temp[t_r - 1][aim] = true;
        for (int i = t_r - 2; i >= 0 ; i--) {
            for (int j = 0; j < t_c; j++) {
                boolean xtemp = (j+arr[i] > t_c - 1)?false:temp[i+1][j+arr[i]];
                temp[i][j] = temp[i+1][j] || xtemp;
            }
        }
        return temp[0][0];
    }
}
