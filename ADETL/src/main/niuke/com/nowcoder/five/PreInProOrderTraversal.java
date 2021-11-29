package com.nowcoder.five;

import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-08-22 13:22
 */
public class PreInProOrderTraversal {
    public static void main(String[] args) {

        ONode head = new ONode(5);
        head.lchild = new ONode(3);
        head.rchild = new ONode(8);
        head.lchild.lchild = new ONode(2);
        head.lchild.rchild = new ONode(4);
        head.lchild.lchild.lchild = new ONode(1);
        head.rchild.lchild = new ONode(7);
        head.rchild.lchild.lchild = new ONode(6);
        head.rchild.rchild = new ONode(10);
        head.rchild.rchild.lchild = new ONode(9);
        head.rchild.rchild.rchild = new ONode(11);

        preOrderUnRecurd(head);
        //inOrderUnRecur(head);d
        //posOrderUnRecur(head);
    }

    public static void preOrderUnRecur(ONode head){
        if(head == null) return;
        ONode cur = head;
        Stack<ONode> stack = new Stack<>();

        stack.push(cur);

        while (stack.size() != 0){
            ONode outPop = stack.pop();
            System.out.print(outPop.value + " ");
            if(outPop.rchild != null){
                stack.push(outPop.rchild);
            }
            if(outPop.lchild != null){
                stack.push(outPop.lchild);
            }
        }

    }

    //意思是这样的：先把把整棵树看成一个个的左子树，遇到左子树就从root开始，一路向左进行压栈，直到最后一个
    //开始弹出数据，弹出后看弹出节点是否有右子树，有的话将右子树的左子树全部压栈
    public static void inOrderUnRecur(ONode head){
        if(head == null) return;
        ONode cur = head;
        Stack<ONode> stack = new Stack<>();
        //cur为空则弹栈，若此时栈为空，就不用玩了
        while (!stack.isEmpty() || cur != null){
            if(cur != null){
                //在该节点下将一路向左的元素进行压栈
                stack.push(cur);
                cur = (cur.lchild != null) ? cur.lchild : null;
            }else {
                cur = stack.pop();
                System.out.print(cur.value + " ");
                cur = (cur.rchild != null) ? cur.rchild : null; //逻辑上好理解一些
            }
        }
    }

    //之前我们遇到空节点，就从栈中弹出节点，而现在没有栈了，怎么寻找上一个不为空的元素
    //中序我们使用的while(cur != null),现在我们使用的是while(cur.left != null)

    //后续遍历就是在前序的基础上，增加一个栈，将弹出的元素放进新的栈里面
    //前序打印顺序是中左右 ，入栈顺序是中右左 ， 我们现在入栈变为中左右，出栈出栈变为中右左，放在另一个栈里面就变为了左右中
    //把它变为了一个定理就行

    public static void posOrderUnRecur(ONode head){

        if(head == null) return;
        Stack<ONode> stack = new Stack<>();
        Stack<ONode> itemStack = new Stack<>();
        ONode cur = head;
        stack.push(cur);

        while(!stack.isEmpty()){
            cur =  stack.pop();
            itemStack.push(cur);
            if(cur.lchild != null) stack.push(cur.lchild);
            if(cur.rchild != null) stack.push(cur.rchild);
        }

        while (!itemStack.isEmpty()){
            System.out.print(itemStack.pop().value + " ");
        }


    }


    public static void preOrderUnRecurd(ONode head){
        if(head == null) return;
        ONode cur = head;
        Stack<ONode> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            ONode preNode = stack.pop();
            System.out.print(preNode.value+" ");
            if(preNode.rchild != null){
                stack.push(preNode.rchild);
            }

            if(preNode.lchild != null) {
                stack.push(preNode.lchild);
            }
        }
    }

}
class ONode{
    int value;
    ONode lchild;
    ONode rchild;

    public ONode(int value) {
        this.value = value;
        lchild = null;
        rchild = null;
    }
}