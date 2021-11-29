package zhenti.other;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-11-12 22:57
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] split = s.split(",");
        System.out.println(fun(split));
    }

    public static String fun(String[] strs){
        if(strs == null || strs.length == 0) return null;

        char[] ch0 = strs[0].toCharArray();
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            char[] chi = strs[i].toCharArray();
            int l = 0;
            for (int j = 0; j < len && j < chi.length; j++) {
                if(j == chi.length-1){
                    if(ch0[j] == chi[j]){
                        len = Math.min(len , j+1);
                    }
                }else if(ch0[j] != chi[j]){
                    len = Math.min(len , j);
                    break;
                }

            }
            if(len ==  0)  break;
        }

        String res = strs[0].substring(0,len);
        return res;
    }
}
