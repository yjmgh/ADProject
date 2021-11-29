package com.offer.jianzhi.fourzhang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yjm
 * @create 2019-10-02 22:17
 */
//题目：分行从上到下打印树
//思路：两个变量 curLin nextLine 分别记录着当前行，下一行的元素个数
//伪代码：使用队列先进先出，没出一个元素，当前行元素少一个 ， 下一行元素进行增加
//当前行元素变为0的时候 ， 打印输出\n ，curLin = nextLine nextLine = 0
public class TreeFenHangDaYin {
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

        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        int curLin = 1;
        int nextLine = 0;

        while (!queue.isEmpty()){
            Node p = queue.poll();
            System.out.print(p.value + " ");
            if(p.left != null){
                queue.offer(p.left);
                nextLine++;
            }

            if(p.right != null){
                queue.offer(p.right);
                nextLine++;
            }

            curLin--;
            if(curLin == 0){
                curLin = nextLine;
                nextLine = 0;
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
