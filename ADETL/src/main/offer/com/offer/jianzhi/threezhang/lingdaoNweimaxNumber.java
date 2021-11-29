package com.offer.jianzhi.threezhang;

/**
 * @author Yjm
 * @create 2019-09-28 21:51
 */
//题目： 打印 1 到 n位最大数 ， 例如 n == 4 则 n位最大数是 9999
//n可能超过32 位 64 甚至更大 两种方法 1 使用字符数组模拟大整数的加法 2 使用全排列
public class lingdaoNweimaxNumber {
    public static void main(String[] args) {
        fun1(5);
    }
    //全排列：
    //从第一个数开始 传递给下面
    public static void fun1(int n){
        if(n <= 0) return;

        char[] chs = new char[n];

        for (int i = 0; i < n; i++) {
            chs[i] = '0';
        }

        process(chs , 0);
    }

    public static void process(char[] chs , int index){
        if(index == chs.length){
            printCharArr(chs);
            return;
        }
//需要当前位置从 0 -- 9
        for (int i = 0; i <= 9; i++) {
            chs[index] = (char)(i + '0');
            process(chs , index+1);
        }


    }
    //字符串数组自增 ：
    //思路： 自增1 当没有超出范围为的时候，就返回false ， 打印当前字符串数组
    //从个位数开始进行循环 ， 在个位数加1 ， 进位的话就运行十位，再运行百位 ... 不进为的话直接break
    //输出的话遇到第一个不是0的数，进行标记 ， 之后的字符全部输出
    public static void fun2(int n){
        if(n <= 0) return;

        char[] chs = new char[n];

        for (int i = 0; i < n; i++) {
            chs[i] = '0';
        }

        while(!incream(chs)){
            printCharArr(chs);
        }

    }

    public static boolean incream(char[] chs){

        boolean flag = false;
        int nsum ;
        int jin_wei = 0;
        for (int i = chs.length-1; i >= 0; i--) {

            nsum = chs[i] - '0' + jin_wei;
            if(i == chs.length-1){
                nsum++;
            }

            if(nsum >= 10){
                if(i == 0) {
                    flag = true;
                }else {
                    nsum -= 10;
                    chs[i] = (char)(nsum + '0');
                    jin_wei = 1;
                }
            }else {
                chs[i] = (char) (nsum + '0');
                break;
            }


        }

        return flag;
    }

    public static void printCharArr(char[] chs){

        boolean flag = false;

        for (int i = 0; i < chs.length; i++) {

            if(!flag && chs[i] != '0'){
                flag = true;
            }

            if(flag){
                System.out.print(chs[i]);
            }
        }
        System.out.println();

    }
}
