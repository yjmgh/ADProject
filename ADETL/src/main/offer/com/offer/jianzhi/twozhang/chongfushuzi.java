package com.offer.jianzhi.twozhang;

/**
 * @author Yjm
 * @create 2019-09-26 15:52
 */
/*
题目：剑指offer  P39页：数组中重复数字为题
1 不借助外部空间找到重复数字
        让数字归为
        1 在该位置上就跳下一个
        2 没有在该位置上就将数字与数字改在的位置上的数字比较，相同就是重复，不同就替换，一直替换到该位置上数字归位

2 先排序 + 窗口
3 使用hashmap

*/
public class chongfushuzi {
    public static void main(String[] args) {
        String s = "hh  kk";
        s = s.replace(" ","%20");
        System.out.println(s);
        /*for (int i = 0; i < sp.length; i++) {
            System.out.println(sp[i].length() );
        }
        System.out.println(sp.length);*/

    }
}
