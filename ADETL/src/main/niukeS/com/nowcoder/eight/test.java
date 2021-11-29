package com.nowcoder.eight;

/**
 * @author Yjm
 * @create 2019-09-23 10:08
 */
public class test {
    public static void main(String[] args) {

    }
    public static boolean fun(char[] str , char exp[] ,int i ,int j){
        if(j == exp.length) return i == str.length;

        //j+1 != '*'
        if(j+1 == exp.length || exp[j+1] != '*'){
            return i != str.length && (exp[j] == str[i] || exp[j] == '.') && fun(str , exp , i+1 ,j+1);
        }

        while (i != str.length && exp[j] == str[i] || exp[j] == '.'){
            if(fun(str , exp , i , j+2)){
                return true;
            }
            i++;
        }

        return fun(str , exp , i , j+2);
    }
}
