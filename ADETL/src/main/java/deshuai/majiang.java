package deshuai;

import java.util.Scanner;

/**
 * @author yuanjiameng
 * @create 2020-08-12 19:45
 */
public class majiang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n <= 0 ) return;

        String[][] arr = new String[n][7];

        for (int i = 0; i <arr.length; i++) {
            String temp = sc.next().trim();
            String[] input = temp.split(" ");
            if(input.length != 7) return;

            for (int j = 0; j < 7; j++){
                arr[i][j] =  input[j].trim();
            }
        }

        for (int i = 0; i <arr.length; i++) {
            int[] w= new int[9];
            int[] b= new int[9];
            int[] z= new int[9];

            int wi = 0;
            int bi = 0;
            int zi = 0;

            for (int j = 0; j < 7; j++){
                char[] ch = arr[i][j].toCharArray();
                if(ch.length != 2) return;

                if('W' == ch[1]) {
                    w[wi] = Integer.parseInt(String.valueOf(ch[0]));
                    wi++;
                }
                if('B' == ch[1]) {
                    b[bi] = Integer.parseInt(String.valueOf(ch[0]));
                    bi++;
                }
                if('Z' == ch[1]) {
                    z[zi] = Integer.parseInt(String.valueOf(ch[0]));
                    zi++;
                }
                //arr[i][j] = input[j];
            }

            int[] w2= new int[wi];
            int[] b2= new int[bi];
            int[] z2= new int[zi];



        }

    }

}
