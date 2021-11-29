package com.nowcoder.seven;

/**
 * @author Yjm
 * @create 2019-09-18 11:41
 */
//N一共有1~N的位置
//M来到的位置
//P可以走的步数
//K最终停在的位置
//返回值：一共有多少种走法能够走到K
//使用递归
//往左走 往右走
public class Jiqiren {
    public static void main(String[] args) {
        System.out.println(process(5 , 3 , 2 , 1 ));
        System.out.println(dpfun(5 , 3 , 2 , 1 ));
    }

    public static int process(int N , int M , int P,int K){
        if(N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) return 0;
        if(P == 0){
           return M == K ? 1 : 0;
        }

        int res = 0;
        if(M == 1){
            res = process(N , M + 1,P -1 ,K);
        }else if(M == N){
            res = process(N , M - 1,P - 1 ,K);
        }else {

            res =process(N , M + 1,P -1 ,K) + process(N , M - 1,P - 1 ,K);
        }

        return res;
    }

    public static int dpfun(int N , int M , int P,int K){
        if(N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) return 0;
        int[][] arr = new int[P+1][N+1];
        arr[0][K] = 1;
        for (int i = 1; i <= P ; i++) {
            for (int j = 1; j <= N ; j++) {
                int l = (j - 1) == 0 ? 0 : arr[i-1][j-1] ;
                int r = (j + 1) ==(N+1) ? 0 : arr[i-1][j+1];
                arr[i][j] = l + r;
            }
        }
        return arr[P][M];

    }

}
