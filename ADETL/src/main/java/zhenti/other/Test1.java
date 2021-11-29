package zhenti.other;

import sun.applet.Main;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-10 19:37
 */
public class Test1 {
    public static void main(String[] args) {
//小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。
// 虽然小希并不知道密码具体是什么，但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。
// 下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，
// 例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] temp = new int[arr.length];
            for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
            }
            System.out.println(mergeSout(arr,0,arr.length-1,temp));
        }

    }


    public static int mergeSout(int[] arr,int left,int right , int[] temp){

        if(arr == null || arr.length == 0) return 0;
        if(left == right) return 0;
        int mid = left + ((right - left) >> 1);
        //找出三个中的最大值
        int item1 = mergeSout(arr,left,mid,temp);
        int item2 = mergeSout(arr,mid+1,right,temp);
        int item3 = merge(arr,left,mid,right,temp);
        return max_int(item1,item2,item3);
    }

    public static int merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int k = 0;
        int res = 0;
        int max = 0;
        int tem =0;
        while(i<= mid&&j<=right){
            if(arr[i] < arr[j]){
                res = mid + right - j + 1;
                if(max < res ) max = res;
                temp[k] = arr[i];
                k++;
                i++;
            }
            if(arr[j] <= arr[i]){
                temp[k] = arr[j];
                k++;
                j++;
            }
            res = 0;
        }

        while(i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= right){
            temp[k] = arr[j];
            k++;
            j++;
        }

        k=0;
        int leftNext = left;
        while(leftNext <= right){
            arr[leftNext] = temp[k];
            k++;
            leftNext++;

        }

        return max;
    }

    public static int max_int(int a , int b,int c){
        if(a >= b){
            if(a >= c){
                return a;
            }else{
                return c;
            }
        }else {
            if( b>= c){
                return b;
            }else{
                return c;
            }
        }

    }
}
