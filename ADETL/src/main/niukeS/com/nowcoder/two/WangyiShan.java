package com.nowcoder.two;

import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-09-08 9:59
 */
//题目，有是个数组 假设是[ 4 , 5 , 2 , 8 , 4 ,4 ,1 ...],形成一座环形的山，
// 相邻的山之间可以相互看见，不相邻的山之间，只要没有大于两者之间最小值的山就可以相互看见，例如4 1 就能相互看见
//求：有多少对能相互看见的山
//解题思路：
// 如果没有重复值：
// 那就找出最大值跟次高值，那么最大值跟次高值之间的元素 i ,
// 两边遇到第一个比它大的值x，就结束，所以i能看到的元素一定能够且仅能够是两个
//如果有重复值：利用单调栈--左边右边第一个比它大的值
//先找出其中一个最大值，将最大值放入，从最大值的下一个值开始，顺时针找，只进行小找大的操作，
// 令i是要确定左右最大值的元素，计算i与左右之间元素的个数就是i能看到的值
//当元素走完了，栈里面还有元素，有超过三个的话 超过3个就 Cn2 + n*2,倒数第二个就Cn2 + n 如果就一个就是 Cn2
public class WangyiShan {
    public static void main(String[] args) {

        int[] arr = new int[]{ 4 , 6 ,3 ,2 ,7 , 4 , 7 , 2 };
        System.out.println(getNumber(arr));
    }

    public static long getIntenalSum(int times){

        return times == 1 ? 0 : (long)times * (long)(times -1) / 2L;
    }
    public static long getNumber(int[] arr){
        if(arr == null || arr.length == 1) return 0;
        if(arr.length == 2) return 1;
        Stack<WNode> stack = new Stack<WNode>();
        //找出最大值
        int max = 0;//最大值所在的位置
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        stack.push(new WNode(max));
        int k = (max == arr.length-1) ? 0 : (max+1);
        long count = 0;
        while(k != max){
            //栈不可能空
            while (arr[stack.peek().p] < arr[k]) {
                int times = stack.pop().times;
                count += getIntenalSum(times) + times * 2;//栈顶元素 右边是k，左边栈不为空因而times * 2
            }
            if(arr[stack.peek().p] == arr[k]){
                stack.peek().times++;
            }else {
                stack.push(new WNode(k));
            }

            k = (k == arr.length-1) ? 0 : (k+1);
        }

        //走完之后就开始依次弹出栈里的元素
        while (!stack.isEmpty()){
            if(stack.size() > 2 ){
                int times = stack.pop().times;
                count += getIntenalSum(times) + times * 2;//栈顶元素 右边是k，左边栈不为空因而times * 2
            }else if(stack.size() == 2){
                int times = stack.pop().times;
                count += getIntenalSum(times) + times ;//栈顶元素 右边是k，左边栈不为空因而times * 2
            }else if(stack.size() == 1){
                int times = stack.pop().times;
                count += getIntenalSum(times);//栈顶元素 右边是k，左边栈不为空因而times * 2
            }
        }

        return count;
    }

}

class WNode{
    int p;
    int times;

    public WNode(int p) {
        this.p = p;
        this.times = 1;
    }
}