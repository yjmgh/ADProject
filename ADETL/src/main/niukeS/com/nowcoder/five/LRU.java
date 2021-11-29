package com.nowcoder.five;

import java.util.HashMap;

/**
 * @author Yjm
 * @create 2019-09-15 20:25
 */
//问题：缓存结构：双端队列里面有有限个位置，当增删改查一个数据的话就将该数据提到最前
//思路：一个双端队列，一个hashmap
//hashmap作用：查询,修改前查询--修改/删除前查询，添加前查询--有的话就修改没有就添加
public class LRU {
    public static void main(String[] args) {

        MyCache testCache = new MyCache(3);
        testCache.set(1,"A");
        testCache.set(2,"B");
        testCache.set(3,"C");
        System.out.println(testCache.get(2));
        System.out.println(testCache.get(1));
        testCache.set(4,"D");
        System.out.println(testCache.get(4));
        System.out.println(testCache.get(3));
    }



}
//自己造一个双向链表，就是一个缓存结构
class NodeDoubleLinkedList{
    //自己造一个队列
    private LNode head;
    private LNode tail;

    public NodeDoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(LNode newNode) {
        if (newNode == null) {
            return;
        }
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.last = this.tail;
            this.tail = newNode;
        }
    }

    public void moveNodeToTail(LNode node) {
        if (this.tail == node) {
            return; //在尾结点
        }
        if (this.head == node) { //在头结点
            this.head = node.next;
            this.head.last = null;
        } else {//既不在头结点也不在尾结点  next朝向tail last朝向head
            node.last.next = node.next;
            node.next.last = node.last;
        }
        //放在tail
        node.last = this.tail;
        node.next = null;
        this.tail.next = node;//将node连接到链表上
        this.tail = node;
    }

    public LNode removeHead() {
        if (this.head == null) {
            return null;
        }
        LNode res = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = res.next;
            res.next = null;
            this.head.last = null;
        }
        return res;
    }
}

 class MyCache {
     private HashMap<Integer, LNode> map;//<K , <K , V>
     private NodeDoubleLinkedList nodeList;
     private int capacity;

     public MyCache(int capacity) {
         if (capacity < 1) {
             throw new RuntimeException("should be more than 0.");
         }
         this.map = new HashMap<>();
         this.nodeList = new NodeDoubleLinkedList();
         this.capacity = capacity;
     }

     public String get(Integer key) {
         if (this.map.containsKey(key)) {
             LNode res = this.map.get(key);
             this.nodeList.moveNodeToTail(res);
             return res.value;
         }
         return null;
     }

     public void set(Integer key, String value) {
         if (this.map.containsKey(key)) {
             LNode node = this.map.get(key);
             node.value = value;
             this.nodeList.moveNodeToTail(node);
         } else {
             LNode newNode = new LNode(key,value);
             this.map.put(key, newNode);
             this.nodeList.addNode(newNode);
             if (this.map.size() == this.capacity + 1) {
                 this.removeMostUnusedCache();
             }
         }
     }

     private void removeMostUnusedCache() {
         LNode removeNode = this.nodeList.removeHead();
         this.map.remove(removeNode.key);
     }
 }

class LNode {
    public int key;
    public String value;
    public LNode last;
    public LNode next;

    public LNode(int key,String value) {
        this.key = key;
        this.value = value;
    }
}