package com.offer.jianzhi.fourzhang;

import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-10-03 16:52
 */
//题目：给出一个值aim ,打印出 跟节点到叶子节点和为aim的整条路径上的节点 ， 有几条路径打印几条路径
//思路：栈记录页节点之前的元素 ， 遇到满足条件的叶节点 ， 使用辅助栈 ， 既可以从根节点也可以从叶节点输出 ， 这里以根节点为例
//代码：1 节点来到cur节点 ， 参数 head为当前节点 ， 栈里元素sum
// 2 判断sum + cur.value ：(sum + cur.value) > aim 此路不通结束
//                         (sum + cur.value) == aim 看cur是否是叶子节点 是 打印 不是 此路不通
//                         (sum + cur.value) < aim   看cur是否是叶子节点 是 此路不通 不是 继续下一个

public class TreeSumAim {

    public static void main(String[] args) {

        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.left.right = new Node(16);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        fun(head , 5);
    }

    public static void fun(Node head , int aim){
        if(head == null) return;

        process(head , aim , 0 ,new Stack<>() , new Stack<>());

    }

    public static void process(Node head , int aim , int sum , Stack<Node> stack , Stack<Node> temp_stack){

        if((sum + head.value) > aim) return;

        if((sum + head.value) == aim){
            if(head.left == null && head.right == null){
                while(!stack.isEmpty()){
                    temp_stack.push(stack.pop());
                }

                while(!temp_stack.isEmpty()){
                    Node temp = temp_stack.pop();
                    System.out.print(temp.value + " ");
                    stack.push(temp);
                }
                System.out.println(head.value);
            }

            return;
        }

        if((sum + head.value) < aim){
            if(head.left == null && head.right == null) return;

            if(head.left == null){ //右一定不为空
                stack.push(head);
                process(head.right , aim , sum + head.value , stack , temp_stack);
            }else if(head.right == null){ //左一定不为空
                stack.push(head);
                process(head.left , aim , sum + head.value , stack , temp_stack);
            }else { //两者都不为空
                stack.push(head);
                process(head.left , aim , sum + head.value , stack , temp_stack);
                process(head.right , aim , sum + head.value , stack , temp_stack);
            }
            stack.pop();  //加入一个节点之后 ， 一定要清理掉 ，不然会妨碍其他路径的
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
