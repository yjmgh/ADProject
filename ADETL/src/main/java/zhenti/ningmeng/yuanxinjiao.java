package zhenti.ningmeng;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-10-18 20:01
 */
//有一个数组，求出1 - 2 的距离 ， 1 - 3 的距离 1 - n的距离 求其最大
//求出i 到从0 到n 的距离 与max比较
// 使用abs函数
public class yuanxinjiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N <= 0) return;
        float[] arr = new float[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextFloat();
        }

        float res = fun(arr);

        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println(df.format(res));
    }

    public static float fun(float[] arr){
        if(arr == null || arr.length == 0) return 0;

        float max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            float temp = 0;
            for (int j = i+1; j < arr.length; j++) {

                    float k = Math.abs(arr[j] - arr[i]);
                    k = (k - 180) > 0 ? (360 - k ) : k;
                    temp =Math.max(temp ,k);

            }

            max = Math.max(temp , max) ;
        }

        return max;
    }
}
//5 1 23.5 179 180.1 190.2