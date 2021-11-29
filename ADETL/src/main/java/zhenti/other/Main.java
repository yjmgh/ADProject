package zhenti.other;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        if(n < 0) System.out.println(false);
        if(n==0 || n==1) System.out.println(true);


        System.out.println(fun_test(str));



    }
    public static boolean fun_test(String str){
        if(str.length() == 0 || str.length() == 1) return true;

        boolean Aflag = false;
        boolean aflag = false;

        char[] chars = str.toCharArray();
        if( 'A'<= chars[0] && 'Z' >= chars[0]){
            if('A'<= chars[1] && 'Z' >= chars[1]){
                Aflag = true;
            }else{
                aflag = true;
            }
        }else{
            aflag = true;

        }

        for(int i = 1;i < str.length() ;i++){
            if(Aflag){
                if('a' <= chars[i] && 'z' >= chars[i]){
                    return false;
                }
            }
            if(aflag){
                if('A' <= chars[i] && 'Z' >= chars[i]){
                    return false;
                }
            }


        }
        return true;
    }

}
