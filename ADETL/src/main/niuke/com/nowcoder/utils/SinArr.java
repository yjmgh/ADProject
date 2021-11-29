package com.nowcoder.utils;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-05 21:02
 */
public class SinArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = "";
        while(sc.hasNext()){
            String str = sc.nextLine();
            //if(str.equals("a")) break;
            strs = strs + str + "_";
        }
        int len = strs.length();
        strs = strs.substring(0 , len -1);

        String[] str2 = strs.split("_");
        int l = str2.length;
        int ll = str2[0].split(",").length;
        String[][] str3 = new String[l][ll];
        int[][] arr = new int[l][ll];
        for (int i = 0; i < l; i++) {
            String[] str4 = str2[i].split(",");
            for (int j = 0; j < ll; j++) {
                str3[i][j] = str4[j];
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < ll; j++) {
                arr[i][j] = Integer.parseInt(str3[i][j]);
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < ll; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
