package tt;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuanjiameng
 * @create 2021-11-29 11:24
 * @describe
 */
// 为不同类型的线程构建不同的等待队列
class Store{
    private LinkedList<String> storage;
    private int maxSize ;
    private Lock lock;

    private Condition consumerQueue;
    private Condition producerQueue;

    public Store(int maxSize) {
        this.maxSize = maxSize;

        lock = new ReentrantLock();
        consumerQueue = lock.newCondition();
        producerQueue = lock.newCondition();

        storage = new LinkedList<String>();

    }

    //生产
    public void product() {
        lock.lock();

        try{
            //仓库空了
            while(storage.size() == maxSize){
                //生产者进行阻塞
                System.out.println (Thread.currentThread().getName()+":wait");
                producerQueue.await();
            }

            //添加数据
            storage.add("java book");
            System.out.println(Thread.currentThread().getName()+": put:"+storage.size());

            Thread.sleep(10);

            consumerQueue.signalAll();//唤醒消费者线程

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //消费
    public void consume() {
        lock.lock();

        try{
            //仓库空了
            while(storage.size() == 0){
                //生产者进行阻塞
                System.out.println (Thread.currentThread().getName()+":wait");
                consumerQueue.await();
            }

            //消费数据
            System.out.println(storage.poll());
            System.out.println (Thread.currentThread().getName()+": left:"+storage.size());

            Thread.sleep(100);

            producerQueue.signalAll();//唤醒生产者线程

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class ProductThread implements Runnable {
    private Store store;

    public ProductThread(Store store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            store.product();
        }
    }
}

class ConsumeThread implements Runnable {
    private Store store;

    public ConsumeThread(Store store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            store.consume();
        }
    }
}
public class ConditionQueueThreadTest {
    public static void main(String[] args) {
        Store store = new Store(3);
        Thread p1 = new Thread(new ProductThread(store));
        Thread c1 = new Thread(new ConsumeThread(store));
        p1.setName("生产者1");
        c1.setName("消费者1");
        p1.start();
        c1.start();
    }
}
