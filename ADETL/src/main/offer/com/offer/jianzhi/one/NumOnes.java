package com.offer.jianzhi.one;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-09-18 10:45
 */
/*
* 解法3：这是一种比较骚的操作，方法如下：
* 把一个整数减去1，再和原整数做与运算，会把该数最右边的一个1变成0，又由于最右边的1的后面都是0，所以与操作也一定是0
* 那么一个整数的二进制中有多少个1，就可以进行多少这样的操作
*
*
* */
public class NumOnes {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //long inputNum = sc.nextInt();
        //
        long inputNum = Long.parseLong(sc.nextLine().trim());
        System.out.println(inputNum);

        System.out.println(Integer.MAX_VALUE);

        long a = 5;
        System.out.println(fun(a));
    }

    public static int fun(long num){
        if (num == 0) return 0;
        int ans=0;
        while (true){
            ans++;
            num = num & (num-1);
            if(num == 0){
                break;
            }
        }
        return ans;
    }

    // 移位比较，为1则加1，否则不加
    public static int getNums(long inpuyNum){
        long moveNum = 1;
        int count_1 = 0;
        for(int i = 0; i <= 63; i++){
            if( (inpuyNum&(moveNum<<i) )  >0){
                count_1++;
            }
        }
        return count_1;
    }
}
