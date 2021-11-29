package com.nowcoder.four;

/**
 * @author Yjm
 * @create 2019-08-21 21:47
 */
public class ZhiPrint {
    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        zhiP(matrix);

    }


    public static void zhiP(int[][] matrix){
        //两个节点,A向右走，B向下走
        int AR = 0;
        int AC = 0;
        int BR = 0;
        int BC = 0;
        boolean flag = false;//代表方向
        int matrixR = matrix.length;
        int matrixC = matrix[0].length;
        while(AR < matrixR){

            levelPrint(matrix , AR , AC ,BR , BC ,flag);
            System.out.println();
            //System.out.println();
            if(AC != matrixC-1){
                AC++;
            }else {
                AR++;
            }

            if(BR != matrixR -1){
                BR++;
            }else {
                BC++;
            }


            flag = !flag;

        }
    }

    public static void levelPrint(int[][] matrix , int AR, int AC, int BR,int BC,boolean flag ){
        if(flag){
            while(AR <= BR){
                System.out.print(matrix[AR][AC] + " ");
                AR++;
                AC--;
            }
        }else {

            while(BR >= AR){
                System.out.print(matrix[BR][BC] + " ");
                BR--;
                BC++;
            }
        }


    }
}
