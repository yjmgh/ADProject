package tt;

import java.util.concurrent.Semaphore;

/**
 * @author yuanjiameng
 * @create 2021-11-29 14:04
 * @describe
 * Semaphore类是个计数信号量，用来限制可以访问特定资源的线程的数量，例如数据库连接资源
 */

class ConnectionProvide{
    public void privode(){
        System.out.println(Thread.currentThread().getName() + " 连接数据库");
    }

}

class HandleUserThread extends Thread{
    private Semaphore semaphore;
    private ConnectionProvide provider;

    public HandleUserThread(Semaphore semaphore, ConnectionProvide provider) {
        this.semaphore = semaphore;
        this.provider = provider;
    }

    @Override
    public void run() {
        if(semaphore.availablePermits() > 0){
            System.out.println(getName() + " start, apply the connection.");
        }else{
            System.out.println(getName() + " start, no available connection");
        }

        try{
            semaphore.acquire();
            provider.privode();
            Thread.sleep(1000);
            System.out.println(getName() + " get connection.");

            //释放资源
            semaphore.release();

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class SemaphoreTest {

    public static void main(String[] args) {
        ConnectionProvide provider = new ConnectionProvide();
        Semaphore semaphore = new Semaphore(2,true);
        for (int i = 0; i < 5; i++) {
            Thread t = new HandleUserThread(semaphore, provider);
            t.setName("线程"+i);
            t.start();
        }
    }

}
