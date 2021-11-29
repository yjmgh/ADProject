package zhenti.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-11 17:45
 */
public class pinduoduo1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double a = 1;
        double b = 1;
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        /*double c = (a + b) / 3;
        System.out.printf("%.2f",c);*/

    }
}
