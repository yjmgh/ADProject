package zhenti.wangyi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yjm
 * @create 2019-08-09 20:55
 */

//给定长度为n的序列，对每一个1<=k<=n,求解所有长度为k的连续子序列的最大值中的最小值
public class wy3 {
    public static void main(String[] args) {
        //使用最大堆和最小堆
        int n = 6;
        int[] arr = {1,3,2,4,6,5};
        int[] arr1 = fun_min_max(arr,n);
        if(arr1 != null){

            for (int item : arr1) {
                System.out.println(item);
            }
        }
    }

    public static int[] fun_min_max(int[] arr , int n){

        if(arr.length != n){
            return null;
        }

        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 -o1;
            }
        });
        int[] cur = new int[arr.length];
        // k 从 1 到 n
        int k = 0;
        for(int i = 0 ;i < n ; i++){
            k = i + 1;
            //k没增加1，就是一次子序列的比较
            for(int j = 0 ;j < n;j = j +  k){

                int l = k;
                while(true){
                    l--;
                    if(l<0){
                        break;
                    }

                    maxHeap.offer(arr[j]);
                    j++;
                }
                int  mx= maxHeap.poll();
                minHeap.offer(mx);

                //将max清空
                while(!maxHeap.isEmpty()){
                    maxHeap.poll();
                }
            }

            cur[i] = minHeap.poll();

            while(!minHeap.isEmpty()){
                minHeap.poll();
            }
        }

        return cur;
    }
}
