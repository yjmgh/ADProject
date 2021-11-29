package com.nowcoder.minor;

import java.util.Stack;

/**
 * @author Yjm
 * @create 2019-08-15 18:50
 */
//每次获得栈中最小的元素，要求O(1)时间
public class GetMinStack {
    public static void main(String[] args) {

        MyMinStack myMinStack = new MyMinStack();
        myMinStack.push(5);
        myMinStack.push(6);
        myMinStack.push(4);

        for (int i = 0; i < 3; i++) {
            System.out.println(myMinStack.getMin()+" "+myMinStack.pop());

        }
       /* myMinStack.getMin();
        myMinStack.pop();*/
    }
}

class MyMinStack{

    Stack<Integer> dataStack;
    Stack<Integer> minStack;

    public MyMinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int number){
        if(minStack.isEmpty()){
            minStack.push(number);
        }else {
            if(number <= minStack.peek()){
                minStack.push(number);
            }else{
                minStack.push(minStack.peek());
            }
        }
        dataStack.push(number);

    }

    public int pop(){
        if(dataStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("your stack is empty");
        }
        int value = dataStack.pop();
        minStack.pop();
        return value;
    }

    public int getMin(){

        if(this.minStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("your stack is empty");
        }
        return this.minStack.peek();
    }
}