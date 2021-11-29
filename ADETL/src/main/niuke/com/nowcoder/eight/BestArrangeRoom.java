package com.nowcoder.eight;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yjm
 * @create 2019-08-29 21:03
 */
/*
一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个个具体的项目），
你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。
*/

public class BestArrangeRoom {
    public static void main(String[] args) {
        int[] arr1 = {0 , 5 , 7 , 8  , 10};
        int[] arr2 = {2 , 7 , 11, 10 , 13};
        System.out.println(bestRoom(arr1, arr2));
    }
    public static int bestRoom(int[] startTime,int[] endTime){
        if(startTime == null || endTime ==null || startTime.length != endTime.length) return 0;
        ProgramNode[] p = new ProgramNode[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            if(startTime[i] > endTime[i]){
                throw  new RuntimeException("data is error");
            }
            p[i] = new ProgramNode(startTime[i],endTime[i]);
        }

        return getArrange(p);
    }
    public static int getArrange(ProgramNode[] p){
        if(p == null) return 0;
        PriorityQueue<ProgramNode> minHeap = new PriorityQueue<>(new Comparator<ProgramNode>() {
            @Override
            public int compare(ProgramNode o1, ProgramNode o2) {
                return o1.endTime - o2.endTime;
            }
        });
        for (int i = 0; i < p.length; i++) {
            minHeap.offer(p[i]);
        }
        int n = 0;
        int endTime = 0;
        while (!minHeap.isEmpty()){
            ProgramNode pd = minHeap.poll();
            if(pd.startTime >= endTime){
                n++;
                endTime = pd.endTime;
                System.out.println("endTime "+endTime);
            }

        }
        return n;

    }

}
class ProgramNode{
    int startTime;
    int endTime;

    public ProgramNode(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}