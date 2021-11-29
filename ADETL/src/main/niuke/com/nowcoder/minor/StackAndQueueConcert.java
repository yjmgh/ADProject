package com.nowcoder.minor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-08-16 12:58
 */
public class StackAndQueueConcert {
    public static void main(String[] args) {
        /*TwoStackQueue twoStackQueue = new TwoStackQueue();

        for (int i = 1; i < 11; i++) {
            twoStackQueue.push(i);
        }

        System.out.println(twoStackQueue.peek() + " " + twoStackQueue.poll());
        twoStackQueue.push(11);
        twoStackQueue.push(12);
        System.out.println(twoStackQueue.peek() + " " + twoStackQueue.poll());*/



        TwoQueueStack twoQueueStack = new TwoQueueStack();
        for (int i = 1; i < 11; i++) {
            twoQueueStack.push(i);
        }

        twoQueueStack.list();
        System.out.println();
        System.out.println(twoQueueStack.peek() + " " + twoQueueStack.pop());
        twoQueueStack.push(11);
        twoQueueStack.push(12);
        twoQueueStack.list();
        System.out.println();
        System.out.println(twoQueueStack.peek() + " " + twoQueueStack.pop());
        twoQueueStack.list();

        System.out.println(twoQueueStack.peek());
    }
}

class TwoStackQueue{
    //dataStack用于存放数据，tempStack用于取数据是做转换栈使用
    Stack<Integer> dataStack ;
    Stack<Integer> tempStack ;


    public TwoStackQueue() {
        dataStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int number){
        dataStack.push(number);
    }

    public int poll(){
        if (dataStack.isEmpty() && tempStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        //倒数据两个原则 1 一次倒完 2 tempStack是空
        if(tempStack.isEmpty()) {
            while (!dataStack.isEmpty()) {
                tempStack.push(dataStack.pop());
            }
        }
        //只要两个栈中有一个非空就可以弹出元素
        return tempStack.pop();
    }
    public int peek(){
        if (dataStack.isEmpty() && tempStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        if(tempStack.isEmpty()) {
            while (!dataStack.isEmpty()) {
                tempStack.push(dataStack.pop());
            }
        }
        //只要两个栈中有一个非空就可以弹出元素
        return tempStack.peek();

    }
}

class TwoQueueStack{
    Queue<Integer> dataQueue = new LinkedList<>();
    Queue<Integer> tempQueue = new LinkedList<>();


    public void push(int number){

        dataQueue.offer(number);

    }

    public int pop(){
        if(this.dataQueue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        while(dataQueue.size() > 1){
            tempQueue.offer(dataQueue.poll());
        }
        int temp = dataQueue.poll();
        swap();
        return temp;
    }

    public int peek(){
        if(this.dataQueue.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        while(dataQueue.size() > 1){
            tempQueue.offer(dataQueue.poll());
        }
        //dataQueue得清空
        int temp = dataQueue.poll();

        //再将tempQueue中的元素移回来了
        while(!tempQueue.isEmpty()){
            dataQueue.offer(tempQueue.poll());
        }
        //最后一个元素
        dataQueue.offer(temp);
        return temp;
    }

    public void swap(){

        Queue<Integer> temp = this.dataQueue;
        this.dataQueue = this.tempQueue;
        this.tempQueue = temp;
    }


    public void list(){
        if(this.dataQueue.isEmpty()) return ;
        Queue<Integer> dataQtemp = new LinkedList<>();

        while(!this.dataQueue.isEmpty()){
            int temp = dataQueue.poll();
            dataQtemp.offer(temp);
            System.out.print(temp + " ");
        }

        this.dataQueue = dataQtemp;
    }

}