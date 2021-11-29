package zhenti.zuoyebang;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-10-15 19:29
 */
//题：使用两个栈实现队列的情况
public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TwoStackQueue list = new TwoStackQueue();

        while (sc.hasNext()){
            String str = sc.next();
            if(str == null || str.length() == 0) return;
            if(str.contains("pop")){
                System.out.println(list.pop());
            }else if(str.contains("push")){
                //list.push(3);
                int temp = Integer.valueOf(str.substring(10,str.length()-2));
                list.push(temp);
            }
        }
    }

    public static class TwoStackQueue {
        //dataStack用于存放数据，tempStack用于取数据是做转换栈使用
        Stack<Integer> dataStack;
        Stack<Integer> tempStack;


        public TwoStackQueue() {
            dataStack = new Stack<>();
            tempStack = new Stack<>();
        }

        public void push(int number) {
            dataStack.push(number);
        }

        public int pop() {
            if (dataStack.isEmpty() && tempStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            }

            if (tempStack.isEmpty()) {
                while (!dataStack.isEmpty()) {
                    tempStack.push(dataStack.pop());
                }
            }
            //只要两个栈中有一个非空就可以弹出元素
            return tempStack.pop();
        }

    }
}