package com.nowcoder.five;

/**
 * @author Yjm
 * @create 2019-09-15 16:25
 */
//题目：在二叉树中找出最长的两个点之间的距离:每个节点只能走一次
//思路：
//三种可能性：
//1 最大距离在左子树
//2 最大距离在右子树
//3 最大距离在当前节点的整棵树上(穿过这个节点)

public class MaxDistanceInTree {
    public static void main(String[] args) {

        XNode head1 = new XNode(1);
        head1.left = new XNode(2);
        head1.right = new XNode(3);
        head1.left.left = new XNode(4);
        head1.left.right = new XNode(5);
        head1.right.left = new XNode(6);
        head1.right.right = new XNode(7);
        head1.left.left.left = new XNode(8);
        head1.right.left.right = new XNode(9);
        System.out.println(XNode(head1));
    }

    public static int XNode(XNode head){
        if(head == null) return 0;
        return fun(head)[1];
    }
    //我需要返回哪些 左子树的深度 0 ， 左子树的最长距离 1
    public static int[] fun(XNode head){
        if(head == null) return new int[]{0,0};

        int[] arr = new int[2];

        int[] arr1 = fun(head.left);
        int[] arr2 = fun(head.right);

        arr[0] = Math.max(arr1[0] ,arr2[0]) + 1;

        arr[1] = Math.max(Math.max(arr1[1],arr2[1]) , arr1[0] + arr2[0] + 1);

        return arr;
    }
}

class XNode{
    int value;
    XNode left;
    XNode right;

    public XNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}