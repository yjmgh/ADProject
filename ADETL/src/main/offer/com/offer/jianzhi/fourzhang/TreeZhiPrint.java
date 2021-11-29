package com.offer.jianzhi.fourzhang;

import java.util.LinkedList;


/**
 * @author Yjm
 * @create 2019-10-02 22:37
 */
//题目：树第一行从左向右打印 ， 第二行从右向左打印 ......
//思路：使用双向链表 ， 当前行式奇数行，正常打印 ， 正常添加子元素 ， 当前是偶数行，从后往前打印 ，从后往前添加子元素 ，
//代码：
//构建双向队列 ， curLine nextLine curNumber 分别表示当前行 ，下一行个数 以及当前行是奇数还是偶数
// 当前行式奇数行，正常打印 ， 正常添加子元素 ，
// 当前是偶数行，从后往前打印 ，从后往前添加子元素
//  curLine == 0 时 curLin = nextLine nextLine = 0 curNumber ^ 1
public class TreeZhiPrint {
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

        fun(head);
    }
    public static void fun(Node head){
       if(head == null) return;
       LinkedList<Node> queue = new LinkedList<>();

       queue.offerFirst(head);
       int curLine = 1;
       int nextLine = 0;
       int curNumber = 1; //1代表奇数行 0代表偶数行

        while(!queue.isEmpty()){
             Node poll;
             if(curNumber == 1){ //在尾部插入子節點
                 poll = queue.pollFirst();
                 System.out.print(poll.value + " ");

                 if(poll.left != null){
                     queue.offerLast(poll.left);
                     nextLine++;
                 }

                 if(poll.right != null){
                     queue.offerLast(poll.right);
                     nextLine++;
                 }

             }else if(curNumber == 0){
                 poll = queue.pollLast();
                 System.out.print(poll.value + " ");

                 if(poll.right != null){
                     queue.offerFirst(poll.right);
                     nextLine++;
                 }

                 if(poll.left != null){
                     queue.offerFirst(poll.left);
                     nextLine++;
                 }

             }

            curLine--;
            if(curLine == 0){
                curLine = nextLine;
                nextLine = 0;
                curNumber ^= 1;
                System.out.println();
            }
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
