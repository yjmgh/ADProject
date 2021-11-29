package zhenti.xueersi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class xueersitwo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0) return;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        fun(arr , n);
    }

    public static void fun(Integer[] arr , double n){

        if(arr.length == 1) {
            System.out.println(arr[0]);
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        
        double temp = n * 0.001;//0.004
        double temp2 = temp + 1;//1.004
        int temp3  = (int)temp2 - 1;//0
        int nn ;
        if(temp > temp3) {
            nn = (int)temp2;
        }else {
            nn = (int)temp;
        }
        int[] tp = new int[nn];
        for (int i = 0; i < nn; i++) {
            System.out.println(arr[i]);
        }


    }
}
