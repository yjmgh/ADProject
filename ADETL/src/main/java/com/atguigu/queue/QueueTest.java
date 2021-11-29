package com.atguigu.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Yjm
 * @create 2019-08-06 21:40
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("Hello");
        queue.offer("World!");
        queue.offer("你好！");

        System.out.println(queue.size());
        String str;
        while((str=queue.poll())!=null){
           System.out.print(str);
         }
        System.out.println();
        System.out.println(queue.size());



    }
}
