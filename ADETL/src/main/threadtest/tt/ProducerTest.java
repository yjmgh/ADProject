package tt;

/**
 * @author yuanjiameng
 * @create 2021-11-27 14:58
 * @describe
 */
class Clerk{
    private int productCount = 0;

    //生产者在产品低于20的时候进行生产
    public synchronized void ProduceProduct(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "生产第" + productCount + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者在产品多余1个的时候进行消费
    public synchronized void ConsumeProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + "消费第" + productCount + "个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Producer extends Thread{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName()+"开始生产产品--------------------------");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.ProduceProduct();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费产品--------------------------");
        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.ConsumeProduct();
        }
    }
}

public class ProducerTest {


    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);
        p1.setName("生产者1");
        c1.setName("消费者1");
        c2.setName("消费者2");
        p1.start();
        c1.start();
        c2.start();
    }

}
