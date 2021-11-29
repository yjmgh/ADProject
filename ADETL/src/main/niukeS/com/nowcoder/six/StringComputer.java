package com.nowcoder.six;

import java.util.LinkedList;

/**
 * @author Yjm
 * @create 2019-09-16 0:01
 */
/*
给定一个字符串str，str表示一个公式，公式里可能有整数、加减乘除符号和左右括号，返回公式的计算结果。
【举例】
str="48*（（70-65）-43）+8*1"，返回-1816。
str="3+1*4"，返回7。str="3+（1*4）"，返回7。
【说明】
1.可以认为给定的字符串一定是正确的公式，即不需要对str做公式有效性检查。
2.如果是负数，就需要用括号括起来，比如“4*（-3）"。但如果负数作为公式的开头或括号部分的开头，则可以没有括号，比如“-3*4”和"（-3*4）”都是合法的。
3.不用考虑计算过程中会发生溢出的情况
*/
public class StringComputer {
    public static void main(String[] args) {

        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getRes(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getRes(exp));
    }

    public static int getRes(String str){
        char[] chs = str.toCharArray();
        return process(chs , 0)[0];
    }

    public static int[] process(char[] chs , int i){

        LinkedList<String> que = new LinkedList<>();
        int pre = 0;
        int[] bra = null;
        while (i < chs.length && chs[i] != ')'){ //第一轮的while是可以把所有的数给进行完的
            if (chs[i] >= '0' && chs[i] <= '9'){
                pre = pre*10 + chs[i] - '0';
                i++;
            }else if(chs[i] != '('){//+ - * / 遇到 + - * /之前一定会遇到数字
                addNum(que , pre);
                que.addLast(String.valueOf(chs[i++]));
                pre = 0;
            }else { // '(' 的情况
                bra = process(chs , i+1); //返回值跟坐标
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que,pre);
        return new int[]{getNumber(que),i};
    }
//这个函数保证队列里面的都是数和加减
    public static void addNum(LinkedList<String> que,int pre){
        if(!que.isEmpty()){
            int cur = 0;
            String top = que.pollLast();
            if(top.equals("+") || top.equals("-")){
                que.addLast(top);
            }else {
                cur = Integer.valueOf(que.pollLast());
                pre = top.equals("*") ? (cur * pre) : (cur / pre);
            }

        }
        que.addLast(String.valueOf(pre));
    }

//只使用+ - 是为了利用res，乘除没法利用
    public static int getNumber(LinkedList<String> que){
        String cur = null;
        boolean add = true;
        int num = 0;
        int res = 0;
        while (!que.isEmpty()){
            cur = que.pollFirst();
            if(cur.equals("+")){
                add = true;
            }else if(cur.equals("-")){
                add = false;
            }else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }
}
