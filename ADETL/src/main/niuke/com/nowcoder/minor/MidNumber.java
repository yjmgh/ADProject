package com.nowcoder.minor;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 寻找中位数
 * @author Yjm
 * @create 2019-08-14 10:02
 */
public class MidNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            MedianHodler mh = new MedianHodler();
            int n = sc.nextInt();
            if(n <= 0) return;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            mh.addArr(arr);
            System.out.println(mh.getMedian());
        }
    }
}
class MedianHodler{
    private  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private  PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void modifyTwoHeapSize(){
        if(this.maxHeap.size() == this.minHeap.size() + 2){
            this.minHeap.offer(this.maxHeap.poll());
        }

        if(this.minHeap.size() == this.maxHeap.size() + 2){
            this.maxHeap.offer(this.minHeap.poll());
        }

    }

    public void addNumber(int number){
        if(this.maxHeap.isEmpty()){
            this.maxHeap.offer(number);
            return ;
        }

        //
        if(number >= maxHeap.peek()){
            this.minHeap.offer(number);
        }else{
            this.maxHeap.offer(number);
        }

        modifyTwoHeapSize();
    }

    public void addArr(int[] arr){
        if(arr == null || arr.length == 0){
            return ;
        }

        for (int i = 0; i < arr.length; i++) {
            addNumber(arr[i]);
        }

    }

    public  int getMedian(){
        int maxSize = this.maxHeap.size();
        int minSize = this.minHeap.size();
        if(maxSize > minSize){
            return maxHeap.peek();
        }

        if(maxSize < minSize){

            return  minHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2;

    }
}