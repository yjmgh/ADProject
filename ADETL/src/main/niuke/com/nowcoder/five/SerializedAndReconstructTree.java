package com.nowcoder.five;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yjm
 * @create 2019-08-25 22:24
 */
public class SerializedAndReconstructTree {
    public static void main(String[] args) {

        Node head = null;
        printTree(head);

        String pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconstructTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);
        System.out.println("====================================");
        head = new Node(1);
        printTree(head);

        pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconstructTree(pre);
        System.out.print("reconstruct tree by pre-order, ");

        printTree(head);
        System.out.println("====================================");
        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconstructTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconstructTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        System.out.println("====================================");

    }

    public static String serializeTree(Node head){
        if(head == null) return "#_";
        String str = head.value+"_";
        String lStr = serializeTree(head.left);
        String rStr = serializeTree(head.right);
        return str+lStr+rStr;
    }

    public static Node reconstructTree(String str){
        if(str == null || str.length() == 0){
            return null;
        }

        Node head ;
        String[] strs = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        return reconstructTree(queue);

    }
    public static Node reconstructTree(Queue<String> queue){
        String value = queue.poll();
        if("#".equals(value)){
            return null;
        }

        Node head = new Node(Integer.valueOf(value));
        head.left = reconstructTree(queue);
        head.right = reconstructTree(queue);
        return head;

    }

    // for test -- print tree
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
