package com.nowcoder.four;

/**
 * @author Yjm
 * @create 2019-08-21 19:25
 */
public class FindNumberInSortedMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 234;
        System.out.println(isContains(matrix, K));
    }

    public static  boolean isContains(int[][] matrix , int k){
        int curR = 0;
        int curC = matrix[0].length - 1;

        while(curR < matrix.length && curC > -1){
            if(matrix[curR][curC] == k){
                return true;
            }else if(k < matrix[curR][curC]){
                curC--;
            }else if(k > matrix[curR][curC]){
                curR++;
            }

        }
        return false;
    }
}
