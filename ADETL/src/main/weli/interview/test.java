public class test {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(2);
        fun(root);

    }

    public static void fun(Node node){

        //当前节点输出
        if(node == null) return;
        System.out.println(node.num);
        //左孩子处理
        fun(node.left);
        //右孩子处理
        fun(node.right);

    }

    static class Node{
        int num;
        Node left;
        Node right;

        public Node(int num){
            this.num = num;
            left = null;
            right = null;

        }
    }
}

/*
    给定一个二叉树的根节点 root ，返回它的 中序 遍历
        输入：root = [1,null,2,3]
        输出：[1,3,2]
*/