package com.atguigu.queue;

import java.util.*;


/**
 * @author Yjm
 * @create 2019-08-06 23:30'
 *
 *
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]

public int[] topKFrequent(int[] nums, int k) {

}
 */
public class levelOrder {
    public static void main(String[] args) {

        //BinaryTree<String> tree ;
        //tree = make();
        //tree.levelOrder();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串");
        String s1 = sc.nextLine();
        System.out.println(s1);
        System.out.println("请输入第二个字符串");
        String s2 = sc.nextLine();
        System.out.println(s2);
    }

    public static BinaryTree<String> make(){
        BinaryTree<String> bt = new BinaryTree<>();
        BinaryNode<String> child_f = new BinaryNode<>("F",null,null);
        BinaryNode<String> child_g = new BinaryNode<>("G",null,null);
        BinaryNode<String> child_c = new BinaryNode<>("C",child_f,child_g);

        BinaryNode<String> child_d = new BinaryNode<>("D",new BinaryNode<>("K"),null);
        BinaryNode<String> child_e = new BinaryNode<>("E");
        BinaryNode<String> child_b = new BinaryNode<>("B",child_d,child_e);

        bt.root = new BinaryNode<>("A", child_b, child_c);
        return  bt;

    }

}

class BinaryTree<T>{
    public BinaryNode<T> root;
    public BinaryTree(){ this.root = null;}
    public boolean isEmply(){ return this.root == null;}

    //先序
    public void preOrder(BinaryNode<T> p){
        if(p == null) return;
        System.out.print(p.data + " ");
        preOrder(p.left);
        preOrder(p.right);
    }

    //中序

    public void inOrder(BinaryNode<T> p){
        if(p == null) return;
        inOrder(p.left);
        System.out.print(p.data + " ");
        inOrder(p.right);

    }

    //后序
    public void postOrder(BinaryNode<T> p){
        if(p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.data + " ");

    }

    //层次遍历
    public void levelOrder(){
        //Queue<BinaryNode> queue = new LinkedList<>();
        if(isEmply()){
            return;
        }
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        BinaryNode<T> p = this.root;
        System.out.println("层次遍历");
        while(true){
            if(p==null){
                break;
            }
            System.out.println(p.data + " ");
            if(p.left != null){
                queue.offer(p.left);
            }
            if(p.right!=null){
                queue.offer(p.right);
            }
            p = queue.poll();
        }
        System.out.println();


    }
}



class BinaryNode<T>{
    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode() {
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}