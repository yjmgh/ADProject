package com.nowcoder.four;

/**
 * @author Yjm
 * @create 2019-08-21 14:05
 */

//将正方形矩阵顺时针旋转90度，输出
//方法是一圈一圈的的操作
public class RorateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
        printMatrix(matrix);
        rorate(matrix);
        printMatrix(matrix);
    }


    public static void rorate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix.length - 1;

        while (tR < dR){
            rorateEage( matrix , tR++ , tC++ , dR-- , dC--);
        }

    }

    public static void rorateEage(int[][] matrix, int tR,int tC,int dR,int dC){
        int len = dC - tC;
        int curC = tC;
        int i = 0;
        while (i != len ){
            int temp = matrix[tR][tC + i]; // 这一圈的第一个数
            matrix[tR][curC] = matrix[dR - i][tC]; //将左下角的数放到第一个
            matrix[dR - i][tC] = matrix[dR][dC - i]; //将右下脚数放在左下角
            matrix[dR][dC - i] = matrix[tR+i][dC]; //将右上脚数放在右下角
            matrix[tR + i][dC] = temp;//将第一个数放在右上角
            i++;
        }
    }

    public static void printMatrix(int[][] matrix){

        if(matrix == null ) return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " " );
            }
            System.out.println();
        }

    }

    /*public static void printMatrixC(int[][] matrix){

        if(matrix == null ) return;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[j][i] + " " );
            }
            System.out.println();
        }

    }*/
}
