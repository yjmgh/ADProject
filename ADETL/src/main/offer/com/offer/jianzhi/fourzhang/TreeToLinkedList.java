package com.offer.jianzhi.fourzhang;


/**
 * @author Yjm
 * @create 2019-10-02 21:25
 */
//二叉搜索树转换为双向链表 P191页
//思路： 左子树转换为链表  右子树转换为链表 与根节点相连
//代码：
//递归函数返回 链表左端点 ， 链表右端点
//与根节点相连
//base:当前为叶节点 左端点 == 右端点 == 根

public class TreeToLinkedList {
    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        ResNode resNode = fun(head);
        Node he = resNode.l_node;
        Node tail = resNode.r_node;
        while (he != null){
            System.out.print(he.value + " ");
            he = he.right;
        }
        System.out.println();
        while (tail != null){
            System.out.print(tail.value + " ");
            tail = tail.left;
        }
    }
    public static ResNode fun(Node root){
        if(root == null) return new ResNode();

        return process(root);

    }

    public static ResNode process(Node head){
        if(head.left == null && head.right == null) return new ResNode(head , head);
        ResNode res = new ResNode();
        ResNode left ;
        ResNode right ;

        if(head.left == null){ //左为空 则右一定不为空
            right = process(head.right);

            right.l_node.left = head;
            head.right = right.l_node;

            res.l_node = head;
            res.r_node = right.r_node;
        }else if(head.right == null){ //右为空 则左一定不为空
            left = process(head.left);

            left.r_node.right = head;
            head.left = left.r_node;

            res.l_node = left.l_node;
            res.r_node = head;
        }else { // 左右都不为空
            left = process(head.left);
            right = process(head.right);

            left.r_node.right = head;
            head.left = left.r_node;

            right.l_node.left = head;
            head.right = right.l_node;

            res.l_node = left.l_node;
            res.r_node = right.r_node;
        }

        return res;
    }
    public static class ResNode{
        Node l_node;
        Node r_node;

        public ResNode() {
            this.l_node = null;
            this.r_node = null;
        }

        public ResNode(Node l_node, Node r_node) {
            this.l_node = l_node;
            this.r_node = r_node;
        }
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
