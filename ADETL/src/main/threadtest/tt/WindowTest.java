package tt;

/**
 * @author yuanjiameng
 * @create 2021-11-25 15:46
 * @describe
 */
public class WindowTest {

    public static void main(String[] args) {
        Window1 w1 = new Window1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();
    }



    static class Window1 implements Runnable{
        private int ticket = 100;
        private Object obj = new Object();
        @Override
        public void run() {
            while(true){
                synchronized(obj){
                    if(ticket > 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+":卖票，票号是 "+ticket);
                        ticket--;
                    }else {
                        break;
                    }
                }
            }
        }
    }

//线程安全的单例模式
    static class Bank{


        private Bank(){};

        private static Bank instance = null;

        public static Bank getInstance(){

            if(instance == null){
                synchronized (Bank.class){
                    if(instance == null){
                        instance = new Bank();
                    }
                }
            }
            return instance;
        }

    }
}
