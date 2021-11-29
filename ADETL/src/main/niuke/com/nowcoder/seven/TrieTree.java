package com.nowcoder.seven;

/**
 * @author Yjm
 * @create 2019-09-04 23:40
 */
//前缀树：1 添加word 2 查找word是否在 3 删除一个word 4 前缀的词频统计（有几个单词是以bc开头的）
public class TrieTree {
    public static void main(String[] args) {

        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.preNumber("zuo"));
    }


}

class Node{
    public int path ;//代表当前节点被走过几次
    public int end;//代表以当前节点结尾的单词的数量
    public Node[] nexts;

    public Node() {
        this.path = 0;
        this.end = 0;
        this.nexts = new Node[26];
    }
}

class Trie{
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str){
        if(str == null) return;
        char[] chs = str.toCharArray();

        Node cur = root;
        int index =0;

        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if(cur.nexts[index] == null){
                cur.nexts[index] = new Node();
            }
            cur = cur.nexts[index];
            cur.path++;
        }

        cur.end++;

    }

    public int search(String str){
        if(str == null) return 0;
        char[] chs = str.toCharArray();

        Node cur = root;
        int index =0;

        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if(cur.nexts[index] == null){
                return 0;
            }
            cur = cur.nexts[index];
        }

        return cur.end;


    }

     public void delete(String str){
         if(str == null) return ;
         if(search(str) == 0) return;
         char[] chs = str.toCharArray();

         Node cur = root;
         int index =0;

         for (int i = 0; i < chs.length; i++) {
             index = chs[i] - 'a';
             if(cur.nexts[index].path == 1) {
                 cur.nexts[index] = null;
                 return;
             }

             cur = cur.nexts[index];
             cur.path--;
         }
         cur.end--;
     }

     public int preNumber(String str){
        if(str == null) return 0;
         char[] chs = str.toCharArray();

         int index = 0;
         Node cur = root;

         for (int i = 0; i < chs.length; i++) {
             index = chs[i] - 'a';
             if(cur.nexts[index] == null){
                 return 0;
             }
             cur = cur.nexts[index];
         }

         return cur.path;
     }
}