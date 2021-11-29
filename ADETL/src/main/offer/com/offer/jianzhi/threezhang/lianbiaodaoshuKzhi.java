package com.offer.jianzhi.threezhang;

import java.awt.image.Kernel;

/**
 * @author Yjm
 * @create 2019-09-28 20:53
 */
//题目：P134
//输出链表中倒数第K个值
//思路：两个指针 p1 p2   p2 - p1 == k-1
//1   p1 p2 同时指着head , p2 行进 k - 1步
//2   p1 p2一起走，直到p2到最后一个元素，此时p1就是我们要寻找的元素
public class lianbiaodaoshuKzhi {
    public static void main(String[] args) {
        LNode head = new LNode(1);
        head.next = new LNode(2);
        head.next.next = new LNode(3);
        head.next.next.next = new LNode(4);
        head.next.next.next.next = new LNode(5);
        head.next.next.next.next.next = new LNode(6);

        //System.out.println(getNode(head, 3).value);
        if(getNode(null , 3) == null) {
            return;
        }else {
            System.out.println(getNode(head, 3).value);
        }
    }

    public static LNode getNode(LNode head , int    K){
        if(head == null || K == 0) return null;

        LNode p1 = head;
        LNode p2 = head;

        for (int i = 0; i < K-1; i++) {
            if(p2.next != null){
                p2 = p2.next;
            }else {
                return null;
            }
        }

        while (true){
            if(p2.next != null){
                p2 = p2.next;
                p1 = p1.next;
            }else {
                break;
            }

        }

        return p1;

    }
}

class LNode{
    int value ;
    LNode next ;

    public LNode(int value) {
        this.value = value;
        this.next = null;
    }
}