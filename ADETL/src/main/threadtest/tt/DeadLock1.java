package tt;

/**
 * @author yuanjiameng
 * @create 2021-11-25 18:43
 * @describe
 */
public class DeadLock1 {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (sb1){
                    sb1.append("a");
                    sb2.append("1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb2){
                        sb1.append("b");
                        sb2.append("2");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sb2){
                    sb1.append("C");
                    sb2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (sb1){
                        sb1.append("D");
                        sb2.append("4");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }).start();



    }
}
