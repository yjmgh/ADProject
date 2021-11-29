package zhenti.wangyi;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-21 16:10
 */
public class wangyi2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0) return;
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(fun(arr[i]));
        }
    }
    public static int fun(int[] arr){ //A B p q
        boolean flag = arr[2]*arr[3] > arr[2] ? true : false;
        int res = 0;
        double A = arr[0];
        double B = arr[1];
        double p = arr[2];
        double q = arr[3];
        while (true){
            if(A > B) break;
            res++;
            if(A + p >= B){
                A = A + p;
            }else if(flag){
                p =p*q;
            }else {
                A = A + p;
            }
        }
        return res;

    }
}
