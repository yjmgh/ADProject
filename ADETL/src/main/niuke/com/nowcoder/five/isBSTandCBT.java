package com.nowcoder.five;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-08-25 21:09
 */
//BST：搜索二叉树
//CBT：完全二叉树
public class isBSTandCBT {
    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        System.out.println(isBST(head));
        System.out.println(isCBT(head));
    }

    public static  boolean isBST(Node head){
        if(head == null) return false;
        Node cur = head;
        Stack<Node> stack= new Stack<>();
        int num = Integer.MIN_VALUE;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;

            }else {
                cur = stack.pop();

                int val = cur.value;
                if(num >= val) return false;
                num = val;

                cur = cur.right;
            }
        }

        return true;
    }
    //使用队列：
    public static boolean isCBT(Node head){
        if(head == null) return false;
        Queue<Node> queue = new LinkedList<>();

        queue.offer(head);
        boolean leav  = false;//当一个节点的左右子树为空，或者只有左子树的时候，那么接下来的节点都该是叶子节点
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            Node l = cur.left;
            Node r = cur.right;
            if((leav && (l != null || r != null))||(l == null && r != null)){
                return false;
            }

            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }else { //如果左子树为空，那么右子树一定为空
                leav = true;
            }

        }

        return true;

    }
}
