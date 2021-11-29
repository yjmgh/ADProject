package com.nowcoder.seven;

/**
 * @author Yjm
 * @create 2019-08-31 19:38
 */
public class GetNumberDao {
    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0, 0, 1, 0, 1, 0}, {1, 1, 1, 0, 1, 0}, {1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}
        };

        System.out.println(getNomberDao(arr));


    }
    public static int getNomberDao(int[][] arr){
        if(arr == null || arr[0] == null) return 0;
        int res = 0;
        int R = arr.length;
        int C = arr[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == 1){
                    res++;
                    inject(arr , i , j , R , C);
                }
            }
        }
        return res;
    }

    public static void inject(int[][] arr,int i,int j , int R , int C){
        if(i < 0 || i >= R || j < 0 || j >= C || arr[i][j] != 1) return;
        //arr[i][j] == 2 如果不做处理的话就会陷入死循环
        arr[i][j] =2;

        inject(arr , i-1, j, R, C); //上
        inject(arr , i+1, j, R, C); //下
        inject(arr , i ,j-1, R, C); //左
        inject(arr , i ,j+1, R, C); //右

    }
}