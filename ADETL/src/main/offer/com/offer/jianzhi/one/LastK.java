package com.offer.jianzhi.one;

/**
 * @author yuanjiameng
 * @create 2021-08-23 11:55
 * @describe
 */
public class LastK {
    public static void main(String[] args) {

        LNode head = new LNode(1);

        LNode counterLNode=head;


        for(int i=2;i<=5;i++){
            counterLNode.next = new LNode(i);
            counterLNode=counterLNode.next;
       }

        System.out.println(getKValues(4,head));

    }

    public static int getKValues(int k, LNode head){
        LNode first=head;
        LNode second=head;

        int counter=1;
        while(counter < k){
            first = first.next;
            counter++;
        }

        while(first.next != null){
            first = first.next;
            second = second.next;
        }

        return second.num;
    }
}
class LNode{
    int num;
    LNode next;

    public LNode(int data){
        this.num = data;
    }
}