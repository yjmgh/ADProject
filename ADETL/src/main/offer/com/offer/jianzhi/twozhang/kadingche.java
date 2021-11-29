package com.offer.jianzhi.twozhang;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-26 20:26
 */
public class kadingche {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("0.0");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0) {
            System.out.println(df.format(0));
            return;
        }

        KNode[] kNodes = new KNode[n];
        for (int i = 0; i < n; i++) {
            kNodes[i] = new KNode(sc.nextInt(),sc.nextInt());
        }

        //DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(df.format(fun(kNodes)));
    }

    public static double fun(KNode[] kNodes){
        if(kNodes == null || kNodes.length == 0) return 0;


        Arrays.sort(kNodes, new Comparator<KNode>() {
            @Override
            public int compare(KNode o1, KNode o2) {
                return ((o2.a*o2.t) - o1.a*o1.t);
            }
        });

        double L = 0;
        double v = 0;
        for (int i = 0; i < kNodes.length; i++) {
            L += v*kNodes[i].t+0.5*kNodes[i].a*kNodes[i].t*kNodes[i].t;
            v = v + kNodes[i].a * kNodes[i].t;
        }
        return L;
    }
}

class KNode{
    int a;
    int t;

    public KNode(int a, int t) {
        this.a = a;
        this.t = t;
    }
}