package zhenti.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-21 15:38
 */
//将数据放在hashMap里面，有工资数组， 提问数组 ， 直接进行输出
public class wangyi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(n < 0 || m < 0) return;
        if(n == 0 || m == 0) System.out.println(0);
        int[] x1 = new int[n];
        int[] m1 = new int[m];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            m1[i] = sc.nextInt();

        }

        fun(x1,m1);
    }
    public static void fun(int[] x , int[] m){
        if(x == null || m == null) return;

        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            int res = 0;
            if(map.containsKey(x[i])){
                 res = map.get(x[i]);
                map.put(x[i] , res+1);
            }else {
                map.put(x[i] , 1);
            }
        }

        int res1 = 0;
        for (int i = 0; i < m.length; i++) {
            if(map.containsKey(m[i])){
                res1 = map.get(m[i]);
            }
            System.out.println(res1);
            res1 = 0;
        }


    }
}
