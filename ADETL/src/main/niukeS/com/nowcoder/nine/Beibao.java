package com.nowcoder.nine;

/**
 * @author Yjm
 * @create 2019-09-23 17:07
 */
//题目：一个背包有一定的承重W，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，记录在数组w中，
// 每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，选出物品的总价值最大。
//解题思路：使用暴力递归 选取 1 取该值 2 不取该值 的最大值返回
// 之后改动态规划
public class Beibao {
    public static void main(String[] args) {
        /*int[] v = new int[]{70 , 71 , 69 , 1};
        int[] w = new int[]{3 , 10 , 1 , 2};*/

        int[] w = {2, 3, 5, 4, 2};
        int[] v = {5, 3, 6, 8, 1};
        /*int[] w = {3 , 8};
        int[] v = {5};*/

        System.out.println(fun(v, w, 9 ));

    }
    public static int fun(int[] v ,int[] w ,int bw ){
        if(v == null || w == null || v.length == 0 || w.length ==0 || bw <= 0) return 0;

        int res = process(v , w , 0 , bw);
        int res1 = process2(v , w , bw);

        if(res == res1) return 1;

        return 0;


    }

    public static int process(int[] v,int[] w, int i , int bw){
        if(i == v.length){
            return 0;
        }
        int r = 0;
       /* //此句不出错的前提是一开始的 v.length > 0 w.length > 0 bw > 0
        if(bw < 0) return -v[i-1];*/
//bw < 0 因为下面这一句 根本就不会出现小于0的情况
        if(bw < w[i]){
            r = process(v , w , i+1 , bw);
        }

        //如果bw < w[i] 就是已经不够了，
        if(bw >= w[i]){
            int yao = process(v , w , i+1 ,bw - w[i]) + v[i];
            int bu_yao = process(v , w , i+1 , bw);
            r = Math.max(yao , bu_yao);
        }

        return r;

    }


    public static int process2(int[] v,int[] w, int bw){
        //i 0 -- i == v.length
        //bw 0 -- bw
        int[][] arr = new int[v.length+1][bw+1];
        for (int i = v.length-1; i >= 0; i--) {
            for (int j = bw; j >= 0 ; j--) {
                int r = 0;
                if(j < w[i]) {
                    r = arr[i+1][j];
                }else {
                    r = Math.max(arr[i+1][j-w[i]]+v[i],arr[i+1][j]);
                }
                arr[i][j] = r;
            }
        }


        return arr[0][bw];
    }
}
