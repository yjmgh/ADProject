package com.offer.jianzhi.threezhang;

/**
 * @author Yjm
 * @create 2019-10-02 10:29
 */
//题目：表示数值的字符串 P127
//思路：123.45e+6 == A.BeC
//字符串数组 ：先匹配A部分，匹配上返回int[2]   int[0]表示是否有数字 ，  int[1]表示下标值
//遇到.就匹配B部分，不含+ -
//遇到e则匹配C部分
//匹配函数：有+-号的AC ，无加减号的B    getA获得有符号的数 ， getB获得无符号的数
public class shuzhizifuchuan {
    public static void main(String[] args) {
        String[] str = {"+100" , "5e2" ,"-123" , "3.146" , "-1E-16"};
        boolean f = true;
        for (int i = 0; i < str.length; i++) {
            f = fun(str[i]);
            if(f == false){
                System.out.println(i);
                break;
            }
        }
        System.out.println(f);

        String[] str1 = {"12e" , "1a3.14","1.2.3" ,"=-5" , "12e+5.4"};
        boolean fl = false;
        for (int i = 0; i < str1.length; i++) {
            fl = fun(str1[i]);
            if(fl == true){
                System.out.println(i);
                break;
            }
        }
        System.out.println(fl);
    }

    public static boolean fun(String str){
        if(str == null || str.length() == 0) return false;

        char[] chs = str.toCharArray();
//A
        int[] arr = getA(chs , 0);// . 之前有没有数字都无所谓
//B
        if(arr[1] != chs.length && chs[arr[1]] == '.'){
            int[] temp = getB(chs , arr[1] + 1);

            if(temp[0] == 1 || arr[0] == 1){
                arr[0] = 1;
            }else {
                arr[0] = 0;
            }
            arr[1] = temp[1];
        }
//C
        if(arr[1] != chs.length && (chs[arr[1]] == 'e' || chs[arr[1]] == 'E')){
            int[] temp = getA(chs , arr[1]+1);
            if(temp[0] == 1 && arr[0] == 1){
                arr[0] = 1;
            }else {
                arr[0] = 0;
            }
            arr[1] = temp[1];
        }

        if(arr[0] == 1 && arr[1] == chs.length){
            return true;
        }else {
            return false;
        }
    }

    public static int[] getA(char[] chs , int i){

        if(i == chs.length) return new int[]{0 , i};

        if(chs[i] == '+' || chs[i] == '-'){
            i++;
        }

        return getB(chs , i);
    }

    public static int[] getB(char[] chs , int i){
        if(i == chs.length) return new int[]{0 , i};
        int k = i;
        int[] arr = new int[2];
        while (i != chs.length && chs[i] >= '0' && chs[i] <= '9'){
            i++;
        }

        if(k != i) {
            arr[0] = 1;
        }
        arr[1] = i;
        return arr;
    }
}
