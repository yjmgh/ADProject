package com.nowcoder.minor;

import org.apache.commons.lang.NullArgumentException;

import java.util.Scanner;

/**
 * @author Yjm
 * @create 2019-08-15 11:58
 */
public class ArrayStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 0) return;
        int[] arr = new int[n];
        MyArrayStack myArrayStack = new MyArrayStack(n);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            myArrayStack.push(arr[i]);
        }

        myArrayStack.list();


        for (int i = 0; i < n; i++) {
            System.out.print(myArrayStack.peek() + " ");
            System.out.print(myArrayStack.pop() + " ");
        }
        System.out.println();
    }
}

class MyArrayStack{
    int[] arr ;
    int size;  //就是size平常就指向空的格子
    int index;
    public MyArrayStack(int n){
        if(n < 0) {
            throw new IllegalArgumentException("the init size less than 0");
        }
        arr = new int[n];
        size = 0;
    }

    public void push(int number){

        if(size == arr.length){
            throw new ArrayIndexOutOfBoundsException("the queue is full");
        }
        arr[size] = number;
        size++;

    }

    public int pop(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        size--;
        return arr[size];
    }

    public int peek(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }

        return arr[size - 1];
    }

    public void list(){
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        int index = size;
        while(index > 0 ){
            System.out.print(arr[index - 1] + " ");
            index--;
        }
        System.out.println();
    }
}