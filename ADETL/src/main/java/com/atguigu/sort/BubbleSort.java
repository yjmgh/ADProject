package com.atguigu.sort;
import java.util.Arrays;
/**
 * @author Yjm
 * @create 2019-08-02 16:30
 */
public class BubbleSort {
    public static void main(String[] arges){

        int[] arrs = new int[]{5 , 9 , 7, 4};
        BubbleS(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public static void BubbleS(int[] arrs){
        if(arrs == null || arrs.length == 0){
            System.out.println("数组无法进行排序");
            return;
        }
        int len = arrs.length;
        boolean flag = false;
        for(int i = 0 ; i < len - 1  ; i++){
            for(int j = 0 ; j < len - i -1 ; j++){
                if(arrs[j] > arrs[j+1] ){
                    flag = true;
                    int temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
        }
    }

}
