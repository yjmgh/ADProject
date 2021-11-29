package com.atguigu.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-08-07 14:56
 */
public class kuohao {
    public static void main(String[] args) {
        //输入
        String str = ")(rttyy())sss)(";
        //调函数
        String an = fun_str(str);

        System.out.println(str);
        System.out.println(an);
        //输出


    }
    public static String fun_str(String str){
        if(str == null || str.length() ==0){
            return "输入有误";
        }

        char[] ch = str.toCharArray();
        char[] an = new char[ch.length];
        StringBuilder strb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ;i < ch.length;i++){
            if(ch[i] == '(') {
                stack.push(i);
                an[i] = ' ';
            }else if(ch[i] == ')'){
                if(!stack.empty()){
                    stack.pop();
                    an[i] = ' ';
                }else{
                    an[i] = '?';
                }
            }else{
                an[i] = ' ';
            }
        }

        while(!stack.empty()){
            an[stack.pop()] = '$';
        }
        for(int i = 0 ;i < an.length ; i++){
            strb.append(an[i]);
        }
        return strb.toString();
    }
}
