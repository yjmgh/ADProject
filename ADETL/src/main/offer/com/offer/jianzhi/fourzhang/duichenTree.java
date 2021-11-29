package com.offer.jianzhi.fourzhang;

/**
 * @author Yjm
 * @create 2019-10-03 16:03
 */
//题目：判断一棵树是否是对称的二叉树
//思路：若是对称二叉树则前序 中 左 右 遍历 ，跟 中 右 左  遍历节点值是一样的 ，若是不一样的则报错
//代码：使用递归 ， 两边遍历的值进行比对
public class duichenTree {
    public static void main(String[] args) {

        Node head = new Node(8);
        head.left = new Node(6);
        head.right = new Node(6);
        head.left.left = new Node(5);
        head.left.right = new Node(7);

        head.right.left = new Node(7);
        head.right.right = new Node(5);

        System.out.println(fun(head));
    }
    public static boolean fun(Node head){
        if(head == null) return false;

        return process(head , head);
    }

    public static boolean process(Node cur1 , Node cur2){

        if(cur1 == null && cur2 == null) {
            return true;
        }

        if(cur1 != null && cur2 != null){
            if(cur1.value == cur2.value){
                if(process(cur1.left , cur2.right) && process(cur1.right , cur2.left)){
                    return true;
                }
            }
        }

        //包含了cur1 或 cur2 其中一个为null的情况 ，cur1.value != cur2.value的情况 ， 以及
        //process(cur1.left , cur2.right) && process(cur1.right , cur2.left)为false的情况4
        return false;
    }
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
