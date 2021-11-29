package com.offer.jianzhi.one;

/**
 * @author yuanjiameng
 * @create 2021-08-30 23:47
 * @describe
 */
public class Test {
    public static void main(String args[]){

        int arr[] = {2,3,5,4,3,2,6,7};
        int length = arr.length;
        int replicaNum =getRepliNum(arr, 1, length-1, length);

        System.out.println(replicaNum);
    }

    public static int getRepliNum(int arr[], int start, int end ,int length){

        if(start == end) return start;
        // 获取中间数据
        int middle = ((end - start)>>1)+start;

        int counter = 0;
        counter = getCount(arr, middle, length);

        if(counter > middle - start+1){
            // 比[start, middle]区间的数据要多，证明该区间用重复数据
            end = middle;
        }else {
            start = middle+1;
        }

        return getRepliNum(arr,start,end,length);
    }

    public static int getCount(int arr[], int middle, int length){

        int counter = 0;
        for(int i = 0; i < length; i++){
            if(arr[i] <= middle){
                counter++;
            }
        }

        return counter;
    }
}
