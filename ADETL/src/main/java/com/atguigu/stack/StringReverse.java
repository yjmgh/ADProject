package com.atguigu.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-08-03 10:01
 */
public class StringReverse {
    public static void main(String[] args) {

        String input = "xihuanyigeren";
        System.out.println(SR(input));
    }

    public static String SR(String input){
        Stack<Character> stack = new Stack<>();
        char[] inp = input.toCharArray();
        char[] outp = new char[inp.length];
        for(int i = 0;i < inp.length;i++){
            stack.push(inp[i]);
        }
        int j = 0;
        while(!stack.empty()&&j<outp.length){
            char ch = stack.pop();
            outp[j] = ch;
            j++;
        }
        return Arrays.toString(outp);
    }
}
