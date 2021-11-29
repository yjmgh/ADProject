package com.nowcoder.four;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-08-21 22:40
 */

//深拷贝特殊的链表，不能够改变原先链表的结构
//使用hashMap能够提前一次性造好所有的节点
public class CopyListWithRandom {
    public static void main(String[] args) {

        Node head = null;
        Node res1 = null;
        printRandLinkedList(head);
        res1 = Copy(head);
        printRandLinkedList(res1);
        printRandLinkedList(head);
        System.out.println("=========================");



        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = Copy(head);
        printRandLinkedList(res1);

        printRandLinkedList(head);
        System.out.println("=========================");
    }


    public static Node Copy(Node head){

        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur , new Node(cur.value));
            cur = cur.next;
        }
        cur = head;

        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }

        return map.get(head);

    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
class Node{
    int value;
    Node next;
    Node rand;

    public Node(int value) {
        this.value = value;
    }
}