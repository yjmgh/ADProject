package zhenti.other;

import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-10 20:24
 */
public class Test3 {
    public static void main(String[] args) {
//举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，
// 那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n >= 2) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Arrays.sort(arr);
                int sum = fun(arr);
                System.out.println(sum);
            } else {
                System.out.println(0);
            }

        }

    }

    public static int fun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int len = arr.length;

        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    sum++;
                }
                if(Double.valueOf(arr[i]) < Double.valueOf(arr[j])*Double.valueOf(0.9)){
                    break;
                }else {
                    sum++;
                }
            }

        }

        return sum;

    }


}


