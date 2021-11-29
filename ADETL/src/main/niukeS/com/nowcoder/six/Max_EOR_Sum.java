package com.nowcoder.six;

import scala.collection.TraversableOnce;

/**
 * @author Yjm
 * @create 2019-09-17 11:18
 */
//题目：求最大异或和子数组
//求以i结尾的最大异或和
//A ^ B = C 那么 C ^ A = B 就是说找到i之间的一个元素结尾的异或和 跟当前元素异或和做异或 最大的那个就是以i结尾的最大异或和
//使用前缀树能够保证时间复杂度是O(N)
public class Max_EOR_Sum {
    public static void main(String[] args) {

        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = fun(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static int fun(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        TrieTree trieTree = new TrieTree();
        int max = Integer.MIN_VALUE;
        int eor = 0;
        trieTree.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, trieTree.maxXor(eor));
            trieTree.add(eor);
        }
        return max;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j < arr.length; j++) {
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
class ENode{
    public ENode[] nexts = new ENode[2];
}

class TrieTree{
    public ENode head = new ENode();

    public void add(int num){

        ENode cur = head;
        for (int move = 31; move >= 0 ; move--) {
            int path = ((num >> move) & 1);
            if(cur.nexts[path] == null){
                cur.nexts[path] = new ENode();
            }
            //cur.nexts[path] = cur.nexts[path] == null ? new ENode() : cur.nexts[path];
            cur = cur.nexts[path];
        }
    }

    public int maxXor(int num){
        //原则 符号位是要找异或后为0的元素，数值位是要找异或后为1的元素
        ENode cur = head;
        int res = 0;
        for (int move = 31; move >= 0 ; move--) {
            int path = (num >> move) & 1;
            int best = move == 31 ? path : (path ^ 1); //0(i) ^ 1 = 1 , 1(i) ^ 1 = 0 ,我们找的是与i相反的
            best = cur.nexts[best] != null ? best : (best^1);
            res |= (path ^ best) << move; // res = xxxx0000  iii= (path ^ best) << best
                                          // iii = 0000x000 整体使用或运算
            cur = cur.nexts[best];
        }

        return res;//res是异或好之后的最大异或和
    }


}

