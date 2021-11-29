package tt;

import org.apache.tools.ant.taskdefs.Sleep;

/**
 * @author yuanjiameng
 * @create 2021-11-27 16:11
 * @describe
 */
public class CommunicationTest {

    static class Number implements Runnable{
        private int number = 0;


        @Override
        public void run() {
            while(true){
                synchronized (this){
                    notify();
                    if(number < 100){
                        number++;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + number);

                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        break;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {

        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
