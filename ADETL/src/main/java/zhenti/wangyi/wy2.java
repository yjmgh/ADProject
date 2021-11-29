package zhenti.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-09 19:21
 */
public class wy2 {
    private static List<Integer> inList = new ArrayList<Integer>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> inList = new ArrayList<Integer>();
        int q = sc.nextInt();

        int x , k;
        for(int i =0 ; i < q ; i++){
            x = sc.nextInt();
            k = sc.nextInt();
            inList.add(x);
            if(exit(k)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }


    }
    public static boolean exit(int x){

        /*int len = inList.size();
        for(int i = 0 ;i < len;i++){


        }

        return false;*/

        boolean flag = false;
        for(int i=0;i<inList.size(); ++ i){
            if((x|inList.get(i)) == x){//与x按位或，值为x
                //reslist.add(intList.get(i));
               flag = true;
               break;
            }
        }
        return flag;

    }


}
