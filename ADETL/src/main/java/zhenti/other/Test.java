package zhenti.other;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();

            Long[] arr = new Long[n];
            int index = 0;
            long min;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            min = Long.MAX_VALUE;

            for (int i = 0; i < n-1; i++) {
                long temp = Math.abs(arr[i] - arr[i+1]);
                if(min > temp){
                    min = temp;
                    index = i;
                }
            }

            System.out.println(arr[index] + " " + arr[index + 1]);
        }


    }

}
