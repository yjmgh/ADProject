package com.offer.jianzhi.fivezhang;

/**
 * @author Yjm
 * @create 2019-10-05 17:02
 */
//题目：丑数
//只包含因子 2 3 5  的数称之为丑数 ， 6 8 是 ， 14不是 , 因为14 = 2 * 7 7不能再进行分解
//思路：构造一个从小到大排序的数组，数组内都是丑数 ， 有三个指针，分别记录 *2 && > 当前最大丑数 ，
//                                                                   *3 && > 当前最大丑数 ，
//                                                                   *3 && > 当前最大丑数
//选取他们中最小的作为下一个丑数
//伪代码在函数中写好
//伪代码：1 构建数组 ，先赋值 1 2 3 ，p2 = 1 ， p3 = 1 , p5 = 0
//       2  计算最小值min arr[p2]*2 == min p2++;
//                       arr[p3]*3 == min p3++;
//                       arr[p5]*5 == min p5++;
//      3 返回arr[num -1]
public class ChouShu {
    public static void main(String[] args) {
        int[] arr = new int[]{11,12,13};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(fun(arr[i]));
        }
    }
    //num 一定大于0，不然不让进fun函数
    public static int fun(int num){//1500
        if(num == 1) return 1;
        if(num == 2) return 2;
        if(num == 3) return 3;

        int[] arr = new int[num];

        int p2 = 1;
        int p3 = 1;
        int p5 = 0;

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        for (int i = 3; i < num; i++) {
            int min = Math.min(arr[p2] * 2,arr[p3] * 3);
            min = Math.min(min , arr[p5]*5);

            arr[i] = min;
            if(arr[p2]*2 == min) p2++;
            if(arr[p3]*3 == min) p3++;
            if(arr[p5]*5 == min) p5++;
        }

        return arr[num-1];
    }
}
