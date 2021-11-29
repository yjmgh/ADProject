package com.nowcoder.eight;

/**
 * @author yuanjiameng
 * @create 2021-09-12 18:02
 * @describe
 */
public class QuanPaiLie {

    public static void permutation_fun(String inputStr) {
        if (inputStr == null) {
            return;
        }
        permutation_fun(inputStr.toCharArray(), 0);
    }

    private static void permutation_fun(char[] inputStr, int begin) {
        if (begin == inputStr.length) {
            System.out.println(inputStr);
        }

        for (int i = begin; i < inputStr.length; i++) {
            /*将第一个字符和后面的字符依次交换*/
            swap(inputStr, i, begin);
            /*对于第一个字符后面的字符，依次和后面的字符进行交换*/
            permutation_fun(inputStr, begin + 1);
            /*由于还要交换其他位到该位，因此要将字符串恢复到未交换的时候的样子*/
            swap(inputStr, i, begin);
        }
    }


    private static void swap(char[] inputStr, int i, int j) {
        char temp = inputStr[i];
        inputStr[i] = inputStr[j];
        inputStr[j] = temp;
    }

    public static void main(String[] args) {
        permutation_fun("abc");
    }
}
