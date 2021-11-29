package com.offer.jianzhi.fivezhang;

/**
 * @author Yjm
 * @create 2019-10-05 22:23
 */
//题目：数字序列中某一位的数字 P225页    0123456789101112131415........ 0是第0为 ， 9是第9位 ， 10中的1是第10位
//思路：要求第K为的数字，先判断K是几位数 ， 1位数有10个 ， 2位数有180个 ， 3位数有2700个........
//确定了有几位数之后 ， 确定在几位数中有几个几位数 例如：1001位是一个三位数 1001 = 270*3 + 1 相当于第1002个数
//                                                   10中1是两位数的0位，那么1就是中间，2是第3位 根据余数就可以知道是哪一个数
//伪代码：Nu = N+1
//1 先确定是几位数 i表示当前是几位数 i == 1时 看Nu是否是否大于 10^i - 10^(i-1) 大于的话 i++  Nu = Nu - 10
//当不大于的时候 ， val = Nu / i  v = Nu / i  val + 10^(i-1) == 370 看余数v v==1就是下一个数的第一位 v== 2就是下一个数的第二位，整除就是当前数的最后一位
public class NumerKwei {
    public static void main(String[] args) {
        System.out.println(fun(0));
    }

    public static int fun(int N){
        if(N < 0) return -1;
        int Nu = N+1;

        int i = 1;
        while (true){
            int i_count = (i == 1 )? 10 : (int)(Math.pow(10,i) - Math.pow(10 , i-1));
            if(Nu > i_count*i){

                Nu -= i_count*i;
                i++;
            }else { // 开始相减的计算 1002此时已经已经变成882
                int val = Nu / i;//270
                int v = Nu % i;//2

                int Numer = i == 1 ? 0 : (int)Math.pow(10 , i-1);//100 表示i位的起始位置
                if(v == 0){
                    Numer += val - 1;
                    char[] chs = String.valueOf(Numer).toCharArray();
                    return chs[chs.length-1] - '0';
                }else {
                    Numer += val;
                    char[] chs = String.valueOf(Numer).toCharArray();
                    return chs[v-1] - '0';
                }
            }


        }

    }

}
