package com.nowcoder.five;

/**
 * @author Yjm
 * @create 2019-08-25 16:44
 */
//在 小于O(N)时间复杂度的情况下，求出完全二叉树的结点数
//解法：从根节点开始，看其右子树的一路向左的根节点有没有到达最大层数，到了的话，左子树就不用算了，没到的话，右子树就不用算了
//这样每一层只需要遍历一个结点，所以Log(n),而每一个结点要到达他的最左子树，需要log(n),所以一共( log(n)^2 )
public class CompletedTreeNum {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(NodeN(head));

    }

    public static int NodeN(Node head){
        if (head == null) return 0;
        //第三个参数是整棵树的高度
        return getCTNuber(head,1,getMostLeftLevel(head,1));
    }

    //最后一次调递归一定是 根 左 右 ，根 左，两种情况之一

    //这个函数表示会把当前节点下的节点个数给输出出来
    public static int getCTNuber(Node head,int level ,int h) {
        if(level == h) return 1;//就是达到了叶子节点了，level有且仅有一次等于h,没有他，34行报空指针
        int sum = 0;
        System.out.println("level + "+(level + 1));
        int r = getMostLeftLevel(head.right, level+1);
        if (r == h) {
            // 左树是满二叉树
            sum = (1 << (h - level)) + getCTNuber(head.right, level + 1, h);//左边是2^(h-level) - 1 + 1(根)
        } else {
            // 右树是满二叉树
            sum = (1 << (h - level) - 1) + getCTNuber(head.left, level + 1, h);
        }

        return sum;
    }
    //获得当前元素的最最左子树的层数
    public static int getMostLeftLevel(Node head,int level){
        while (head != null){
            level++;
            head = head.left;
        }
        return (level - 1) ;
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
