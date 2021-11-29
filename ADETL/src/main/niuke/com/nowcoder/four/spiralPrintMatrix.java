package com.nowcoder.four;

/**
 * @author Yjm
 * @create 2019-08-20 23:08
 */
public class spiralPrintMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },{ 13, 14, 15, 16 }};
        printMatrix(matrix);
        spiralPrint(matrix);

    }
//旋转
    public static void spiralPrint(int[][] matrix){
        if(matrix == null || matrix.length == 0) return;

        int tR = 0; //左上角行
        int tC = 0; //左上角列
        int dR = matrix.length -1;
        int dC = matrix[0].length-1;

        while(tR <= dR && tC <= dC){
            printEage(matrix,tR++,tC++,dR--,dC--);
        }


    }
    public static void printEage(int[][] matrix ,int tR,int tC,int dR,int dC){
        if(tR == dR){
            for (int i = tC; i <= dC ; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        }else if(tC == dC){
            for (int i = tR; i <= dR ; i++) {
                System.out.print(matrix[i][tC] + "");
            }
        }else{
            //无论行还是列都是从第一个到倒数第一个
            //分四块
            //上行
            int curR = tR;
            int curC = tC;
            while (curC != dC){
                System.out.print(matrix[tR][curC] + " ");
                curC++;
            }
            //System.out.println();

            //右列
            while(curR != dR){
                System.out.print(matrix[curR][dC] + " ");
                curR++;
            }
            //System.out.println();

            //下行
            while (curC != tC){
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }
            //System.out.println();

            //左列
            while (curR != tR){
                System.out.print(matrix[curR][tC] + " ");
                curR--;
            }
            //System.out.println();
        }


    }

//矩阵输出
    public static void printMatrix(int[][] matrix){

        if(matrix == null ) return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " " );
            }
            System.out.println();
        }

    }

}
