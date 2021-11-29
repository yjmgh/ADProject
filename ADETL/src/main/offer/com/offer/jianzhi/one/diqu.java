package com.offer.jianzhi.one;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-25 20:13
 */
//华为题：地区问题：q u
public class diqu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s22 = sc.nextLine().split(" ");
        int N = Integer.valueOf(s22[0]);
        int M = Integer.valueOf(s22[1]);

        int[] arr = new int[N];
        Node[] node = new Node[M];
        String[] s33 = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(s33[i]);
        }
        //String str = "abcdefrABCDEFG()012345678987654 BCDEF";

        for (int i = 0; i < M; i++) {
            String str = sc.next();
            node[i] = new Node(str , sc.nextInt(),sc.nextInt());
            /*node[i].s = str;
            node[i].A = sc.nextInt();
            node[i].B = sc.nextInt();*/
        }

        fun(arr , node);
    }

    public static void fun(int[] arr , Node[] node ){

        int n_l = node.length;

        for (int i = 0; i < n_l; i++) {
            if(node[i].s.equals("Q")){
                int A = node[i].A;
                int B = node[i].B;
                int x = 0;
                for (int j = A-1; j <= B-1 ; j++) {
                    x += arr[j];
                }
                System.out.println(x/(B - A + 1));
            }else if(node[i].s.equals("U")){
                int A = node[i].A;
                int B = node[i].B;
                arr[A-1] = arr[A-1] + B;
            }
        }
    }
}

class Node{
    String s ;
    int A;
    int B;

    public Node(String s, int a, int b) {
        this.s = s;
        A = a;
        B = b;
    }
}