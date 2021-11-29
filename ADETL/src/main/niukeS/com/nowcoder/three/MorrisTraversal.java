package com.nowcoder.three;

/**
 * @author Yjm
 * @create 2019-09-13 16:36
 */
//morris遍历：在O(N)时间复杂度的情况下，使用O(1)的空间复杂度，实现二叉树的遍历，就是模拟递归版本，实现两次回到一个节点
//递归版本是回到一个节点3次
    //morris所有的叶子节点被遍历1次，所有的非页节点被遍历2次
    //来到的当前节点，记为cur
// 1) 如果cur无左孩子，cur向右移动
// 2) 如果有右孩子，找到cur的左子树上的最右节点的节点，记为mostRight，
//      1 如果mostRight的right指针指向空，让其指向cur，cur向左移动
//      2 如果mostRight的right指针指向cur，让其指向空，cur向右移动
public class MorrisTraversal {
    public static void main(String[] args) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        printTree(head);
        morrisIn(head);
        morrisPre(head);
        printTree(head);
    }

    public static void morrisIn(Node head){
        if(head == null) return;

        Node cur = head;
        Node mostRight = null;//相当于线索二叉树，一个节点的左子树的最右节点的下一个节点一定是当前节点

        //有两个一个是cur 和 MostRight
        //cur是真正的遍历，MostRight是为了修改指针
        //第二次回到cur的之前需要把指针变回来
        while(cur != null){
            //修改mostRight的指针
            mostRight = cur.left;
            //cur第一次走不进行输出，也就有了continue的语句，等到再次回到当前节点的时候，将mostRight置空，并在进入right之前输出
            //如果是叶节点的话直接进行输出就行，因为叶节点在他还是子节点的时候它的right就被链上下一个节点了

            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){ //第一次遍历到最右子树节点
                    mostRight.right = cur;
                    cur = cur.left;
                    continue; //跳出的while(cur != null)这个
                }else {
                    mostRight.right = null; //第二次遍历到最右子树节点
                }
            }

            System.out.println(cur.value + " ");
            cur = cur.right;

        }

        System.out.println();

    }

    public static void morrisPre(Node head){
        if(head == null) return;

        Node cur = head;
        Node mostRight = null;//相当于线索二叉树，一个节点的左子树的最右节点的下一个节点一定是当前节点

        //有两个一个是cur 和 MostRight
        //cur是真正的遍历，MostRight是为了修改指针
        //第二次回到cur，需要把指针变回来，它的左子树该做的事都做完了
        while(cur != null){
            //修改mostRight的指针
            mostRight = cur.left;
            //前序遍历的话就是在走到下一个节点之前先输出，当走到叶子节点的时候就输出叶子节点，此时叶子节点的父节点都已经被输出过了
            //因而不在输出了
            //
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){ //第一次遍历到最右子树节点
                    mostRight.right = cur;
                    System.out.println(cur.value + " ");//有左子树那么一定会遍历两边，第一次就遍历了
                    cur = cur.left;
                    continue; //跳出的while(cur != null)这个
                }else {
                    mostRight.right = null; //第二次遍历到最右子树节点
                }
            }else {//是当前节点就没有左子树，那么也就没有先中再左的问题，当前节点只会来一次，包含两种情况，叶子节点和只有右子树的节点
                System.out.println(cur.value + " ");
            }
            cur = cur.right;

        }

        System.out.println();

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
    Node left;
    Node right;

    public Node(int data) {
        this.value = data;
    }
}