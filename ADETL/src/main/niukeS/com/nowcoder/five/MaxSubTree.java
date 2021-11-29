package com.nowcoder.five;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author Yjm
 * @create 2019-09-15 16:53
 */
//问题：求最大子树：最大子树必须是二叉搜索树
//1 最大二叉搜索树在左子树里面
//2 最大二叉搜索树在右子树里面
//3 最大二叉搜索树包括当前节点
public class MaxSubTree {
    public static void main(String[] args) {
        XNode head = new XNode(6);
        head.left = new XNode(1);
        head.left.left = new XNode(0);
        head.left.right = new XNode(3);
        head.right = new XNode(12);
        head.right.left = new XNode(10);
        head.right.left.left = new XNode(4);
        head.right.left.left.left = new XNode(2);
        head.right.left.left.right = new XNode(5);
        head.right.left.right = new XNode(14);
        head.right.left.right.left = new XNode(11);
        head.right.left.right.right = new XNode(15);
        head.right.right = new XNode(13);
        head.right.right.left = new XNode(20);
        head.right.right.right = new XNode(16);
        System.out.println(getNumber(head));
    }

    public static int getNumber(XNode head){
        if(head == null) return 0;
        //int[] record = new int[3]; //
        ResultType h = fun(head);
        //System.out.print(h.head.value + " ");
        travel(h.head);
        System.out.println();
        return h.size;
    }

    public static ResultType fun(XNode head){

        if(head == null) return new ResultType(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);

        ResultType lr =  fun(head.left);
        ResultType rr = fun(head.right);

        int min = Math.min(Math.min(lr.min,rr.min),head.value);//当前节点下的最小值
        int max = Math.max(Math.max(lr.max,rr.max),head.value);//当前节点下的最大值

        if(head.left == lr.head && head.right == rr.head && head.value > lr.max && head.value < rr.min){
            //还有左右子树为空的情况，所以不能直接lr.min ,rr.max
            return new ResultType(lr.size + rr.size + 1,head ,min,max);
        }

        int size = lr.size > rr.size ? lr.size : rr.size;
        XNode head1 = lr.size > rr.size ? lr.head:rr.head;
        return new ResultType(size,head1,min,max);
    }

    public static void travel(XNode head){
        if(head == null) return;
        travel(head.left);
        System.out.print(head.value + " ");
        travel(head.right);

    }
}
class ResultType{
    int size;
    XNode head;
    int min; //右子树最小
    int max; //左子树最大

    public ResultType( int size,XNode head, int min, int max) {
        this.head = head;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}