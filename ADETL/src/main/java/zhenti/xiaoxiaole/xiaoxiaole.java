package zhenti.xiaoxiaole;

/**
 * @author Yjm
 * @create 2019-09-06 23:57
 */
public class xiaoxiaole {
    public static void main(String[] args) {

        System.out.println(fun(3));
        System.out.println(fun(7));
    }
    public static int fun(int n){

        int sum = 0;
        int targe = 1;
        while(targe <= n){
            if((n&targe) != 0){
                sum++;
            }

            targe = targe<<1;
        }

        return sum;
    }
}
