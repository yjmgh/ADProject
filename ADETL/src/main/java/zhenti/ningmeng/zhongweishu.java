package zhenti.ningmeng;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-10-18 19:25
 */
//求两个有序数组的中位数
public class zhongweishu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N <= 0) return;
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }



        if(arr1 == null || arr1.length == 0){
            if(arr2 == null || arr2.length == 0) return;
            int aim = arr2[(0 + N - 1) / 2];
            System.out.println(aim);
            return;
        }

        if(arr2 == null || arr2.length == 0){
            if(arr1 == null || arr1.length == 0) return;
            int aim = arr1[(0 + N - 1) / 2];
            System.out.println(aim);
            return;
        }

        int aim = fun(arr1 , arr2);
        System.out.println(aim);

    }
//在主函数里面判断空值的情况
    public static int fun(int[] arr1 , int[] arr2){

        int l = 0;
        int r = arr1.length;
        int n = arr1.length;

        double max = -1;
        double min = -1;

        while (true){
            int i = l + (r - l >> 1);

            int j = (2 * n + 1) / 2 - i;

            if(i < n && arr1[i] < arr2[j - 1]){
                l = i+1;
            }else if(i > 0 && arr1[i-1] > arr2[j]){
                r = i-1;
            }else {
                if(i == 0){
                    max = arr2[j-1];
                }else if(j == 0) {
                    max = arr1[i-1];
                }else {
                    max = Math.max(arr2[j-1] , arr1[i-1]);
                }

                if(i == n){
                    min = arr2[j];
                }else if(j == n) {
                    min = arr1[i];
                }else {
                    min = Math.min(arr2[j] , arr1[i]);
                }

                return (int)(max + min) / 2;
            }


        }

    }
}
/*
*c++ 不太会写
* */