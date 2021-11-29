package zhenti.pinduoduo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-11 16:05
 */
public class pinduoduo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            if (n <= 2) return;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            double min_res = Double.MAX_VALUE;
            for (int i = 0; i < arr.length - 2; i++) {
                double min1 = min_fun(arr[i], arr[i + 1], arr[i + 2]);

                if (min_res > min1) {
                    min_res = min1;
                }
            }

        BigDecimal big = new BigDecimal(min_res);
        min_res =big.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(min_res);

    }

    public static double min_fun(int a , int b,int c){
        if(a == 0 && b == 0&& c==0) return 0;
        double aa = Double.valueOf(a);
        double bb = Double.valueOf(b);
        double cc = Double.valueOf(c);
        double avg = (aa +  bb +  cc) / 3.0;

        double res = ((aa - avg)*(aa - avg) + (bb - avg)*(bb - avg)+(cc - avg)*(cc - avg))/3.0;
        BigDecimal big = new BigDecimal(res);
        res =big.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        return res;

    }
}
