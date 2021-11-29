package com.nowcoder.utils;


/**
 * @author Yjm
 * @create 2019-08-22 23:00
 */
public class PrintBinaryTree {
    public static void main(String[] args) {
        Node head = new Node (5);
        head.left= new Node (3);
        head.right= new Node (8);
        head.left.left= new Node (2);
        head.left.right= new Node (4);
        head.left.left.left= new Node (1);
        head.right.left= new Node (7);
        head.right.left.left= new Node (6);
        head.right.right= new Node (10);
        head.right.right.left= new Node (9);
        head.right.right.right= new Node (11);
        printTree(head);
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }
}
