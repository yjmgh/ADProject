package zhenti.other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-03 20:30
 */
public class MaxInt {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n <= 0 ) System.out.println(0);

        int[] arr = new int[n];

        for (int i = 0; i <arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        test(arr);

    }
    public static void test(int[] arr) {

        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = ""+arr[i];
        }

        Arrays.sort(str, (o1 ,o2) ->(o2 + o1) .compareTo(o1+o2));

        /*Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1) .compareTo(o1+o2);
            }
        });*/

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }

        System.out.println(sb.toString());

    }
}
