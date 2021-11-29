package com.nowcoder.minor;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-15 13:06
 */
public class ArrayQueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0) return;
        int[] arr = new int[n];
        MyQueue myQueue = new MyQueue(n);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            myQueue.push(arr[i]);
        }

        myQueue.list();


        for (int i = 0; i < n; i++) {
            System.out.print(myQueue.peek() + " ");
            System.out.print(myQueue.pop() + " ");
        }

        System.out.println();

    }
}
class MyQueue{

    int[] arr;
    int size;
    int front;
    int end;

    public MyQueue(int n) {
        if(n < 0){
            throw new IllegalArgumentException("the init size less than 0");
        }
        arr = new int[n];
        size = 0;
        front = 0;
        end = 0;
    }

    public void push(int number){
        if(size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the stack is full");
        }
        size++;
        arr[end] = number;
        if(end == arr.length - 1){
            end = 0;
        }else {
            end++;
        }
    }

    public int pop(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        size--;
        int temp = front;
        if(front == arr.length - 1){
            front = 0;
        }else {
            front++;
        }
        return arr[temp];
    }
    public int peek(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        return arr[front];
    }
    public void list(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the queue is empty");
        }
        int temp = front;
        int tempSize = size;

        while (tempSize > 0){
            System.out.print(arr[temp] + " ");
            if(temp == arr.length - 1){
                temp = 0;
            }else {
                temp++;
            }
            tempSize--;
        }
    }

}