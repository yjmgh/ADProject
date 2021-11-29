package tt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuanjiameng
 * @create 2021-11-27 20:41
 * @describe
 */
class NumberThread2 implements Runnable {

    @Override
    public void run(){
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if(i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
    }
}
public class ThreadPoolTest {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread2());
        service.shutdown();
    }
}
