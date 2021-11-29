package com.nowcoder.two;

import java.io.PushbackInputStream;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-09-08 14:45
 */
//求最大子矩阵的大小【题目】
//给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
//例如：
//1 1 1 0 其中，最大的矩形区域有3个1，所以返回3。
//再如：
// 1 0 1 1
// 1 1 1 1
// 1 1 1 0
// 其中，最大的矩形区域有6个1，所以返回6。
//解题思路：使用单调栈，计算出当前元素的左右第一个比自己小的元素
//一旦遇到比自己小的元素就可以进行计算了
public class BestChang {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1 ,0 ,1 ,1},{1 ,1 ,1 ,1},{1 ,1 ,1 ,0}};
        System.out.println(getNumber(arr));
    }

    public static int getNumber(int[][] arr){
        if(arr == null) return 0;
        // 1 先计算第一行
        int k;//当前行到第一行
        int[] temp = new int[arr[0].length];
        int maxArea = 0;
         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr[0].length; j++) {
                 temp[j] = arr[i][j] == 0 ? 0 :temp[j] + arr[i][j];
             }
             int res = getOneHang(temp);
             maxArea = maxArea >= res ? maxArea : res;
        }
        return maxArea;
    }

    public static int getOneHang(int[] arr){
        if(arr == null) return 0;
        if(arr.length == 1) return arr[0];
        Stack<BNode> stack = new Stack<>();

        //找以当前元素为高，左边第一个比它小的元素，右边比它小的元素 -- 单调小栈
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek().p] > arr[i]){
                int cur =stack.pop().p;
                int k = stack.isEmpty() ? -1 : stack.peek().p;//栈里面有元素就到栈里的元素，栈里没元素就到最右边
                int len = i - k - 1;
                maxArea = Math.max(maxArea,arr[cur] * len);
            }
            stack.push(new BNode(0));

        }

        while (!stack.isEmpty()){
            int cur =stack.pop().p;
            int len = arr.length - cur;
            maxArea = maxArea >= (arr[cur] * len) ? maxArea :(arr[cur] * len);
        }

        return maxArea;
    }
}
//用不着times，因为遇到相同的之前那个也可以先计算出来
class BNode{
    int p;
    int times;

    public BNode(int p) {
        this.p = p;
        this.times = 1;
    }
}