package com.nowcoder.two;


/**
 * @author Yjm
 * @create 2019-09-10 17:00
 */
//使用BFPRT算法在O(N)时间内找出数组中第k大或小的数4
//流程是这样的：
// 1 找到整个数组的的中位数
// 2  快排方式：以中位数为划分点，得到划分点的数组就能确定中间的第多少小的了例如：2 1 3 3 8 7   第三小的是3
// 3 递归调用 1 2
public class diKthBFPRT {
    public static void main(String[] args) {
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
        printArray(getMinKNumbersByBFPRT(arr, 11));

    }
//这个函数能将前K个小的数都输出出来
    public static int[] getMinKNumbersByBFPRT(int[] arr , int k){
        if(k < 1 || k > arr.length) return arr;

        int minKth = getMinKth(arr , k);//问题1
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < minKth){
                res[index++] = arr[i];
            }
        }

        for(;index != res.length;index++){
            res[index] = minKth;
        }
        return res;
    }

    public static int getMinKth(int[] arr , int k){
        int[] copArray = copyArray(arr);
        return BFPRT(copArray , 0 ,copArray.length-1,k-1);
    }

    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static int BFPRT(int[] arr , int begin , int end ,int i){
        if(begin==end) return arr[begin];

        //找到中位数的点
        int pivot = medianOfMedians(arr , begin , end);//找到当前数组的中位数
        int[] res = partition(arr , begin , end , pivot); // 进行快排的划分

        if(res[0] <= i && res[1] >= i){
            return arr[i];
        }else if(i < res[0]){
            return BFPRT(arr , begin , res[0]-1,i);
        }else {
            return BFPRT(arr , res[1] + 1 , end,i);
        }

    }

    public static int medianOfMedians(int[] arr , int begin , int end){
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num/5 + offset];//新的数组
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i*5;
            int endI = begin+4;
            mArr[i] = getMedian(arr , beginI, Math.min(end , endI));
        }
        return BFPRT(mArr,0 ,mArr.length-1 , mArr.length/2);
    }

    public static int[] partition(int[] arr , int begin , int end , int pivoit){//荷兰国旗问题
        int small = begin - 1;
        int big = end + 1;
        int cur = begin;
        while (cur < big){
            if(arr[cur] < pivoit){
                small++;
                swap(arr , small , cur);
                cur++;
            }else if(arr[cur] > pivoit){
                big--;
                swap(arr,cur,big);
            }else {
                cur++;
            }

        }
        int[] res = new int[2] ;
        res[0] = small+1;
        res[1] = big-1;
        return res;


    }

    private static int getMedian(int[] arr, int begin, int end) {
        insertSort(arr,begin,end);
        int sum = end + begin;
        int mid = sum / 2 + (sum % 2);
        return arr[mid];
    }

    public static void insertSort(int[] arr ,int begin , int end){
        for (int i = begin + 1; i < end + 1; i++) {
            for (int j = i; j > begin ; j--) {
                if(arr[j - 1] > arr[j]){
                    swap(arr , j-1,j);
                }else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
