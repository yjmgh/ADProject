package com.nowcoder.five;

/**
 * @author Yjm
 * @create 2019-08-25 22:02
 */
public class isBalanceTree {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.left.left = new Node(5);
        //head.right.left = new Node(5);
        System.out.println(isB(head).flag);
    }

    //返回值应该是两个：是否是平衡二叉树，以及高度
    public static ResNode isB(Node head){
        //这个就是递归终结的标志
        if(head == null) return new ResNode(true , 0);

        ResNode lTree = isB(head.left);
        ResNode rTree = isB(head.right);
        if(!lTree.flag || !rTree.flag) {
            return new ResNode(false , 0);
        }
        if(Math.abs(lTree.h - rTree.h) > 1 ){
            return new ResNode(false , 0);
        }

        return new ResNode(true , Math.max(lTree.h , rTree.h)+1);
    }
}
class ResNode{
    boolean flag;
    int h ;

    public ResNode(boolean flag, int h) {
        this.flag = flag;
        this.h = h;
    }
}