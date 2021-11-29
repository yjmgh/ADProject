package ry;

import java.util.*;

/**
 * @author yuanjiameng
 * @create 2021-11-22 20:16
 *
 *荣耀面试题
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]

public int[] topKFrequent(int[] nums, int k) {

}
 * @describe
 */
public class FirstK {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        //int[] a = topKFrequent(arr, 2);
        //for (int i = 0; i < a.length; i++) {
        //    System.out.println(a[i]);
        //}//(o1,o2) -> (int)o1 - o2)

        //System.out.println(Math.round(5.4));

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

//nums = [1,1,1,2,2,3], k = 2
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap map = new HashMap<Integer,Integer>();
        PriorityQueue<Node> p = new PriorityQueue<Node>((o1,o2) -> (o1.fre - o2.fre));

        for(int i =0; i< nums.length ;i++){
            if(map.containsKey(nums[i])){
                int res = (int) map.get(nums[i]);
                map.put(nums[i], res+1);
            }else{
                map.put(nums[i], 1);
            }

        }

        for(Object entry: map.entrySet()){
            Map.Entry<Integer,Integer> e = (Map.Entry<Integer,Integer>)entry;
            if(p.size() < k){
                p.add(new Node(e.getKey(),e.getValue()));
            }else{
                if(p.peek().fre < e.getValue()){
                    p.poll();
                    p.add(new Node(e.getKey(),e.getValue()));
                }
            }
        }

        int arr[] = new int[k];
        int i = 0;
        for(Node node : p){
            arr[i] = node.value;
            i++;
        }

        return arr;
    }


    static class Node{
        int value;
        int fre;
        public Node(int value, int fre) {
            this.value = value;
            this.fre = fre;
        }
    }

}
