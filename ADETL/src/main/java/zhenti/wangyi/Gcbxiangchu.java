package zhenti.wangyi;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-09 10:42
 */
public class Gcbxiangchu {

    /*
    a = g*l
    b = g*
    a = b*k + r
    r = g*(l-m*k) =g*c
    就是说a b r 有共同的最大公约数g，将规模减小，假设b < a 则将 b r作为下一次的输入
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a ;
        int b ;
        System.out.println("请输入数据，每行两个数字：");
        while(sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(gcb(a,b));//最大公约数
            System.out.println(a*b/gcb(a,b));//最小公倍数
        }

    }

    public static int gcb(int a,int b){
        if(b == 0){
            return a;
        }
//以b为基准点，a%b <= b,将范围缩小
        return gcb(b , a%b);
    }

}
