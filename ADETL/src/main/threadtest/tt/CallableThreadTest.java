package tt;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yuanjiameng
 * @create 2021-11-27 16:58
 * @describe
 */
class NumberThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if(i%2 == 0){
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}

public class CallableThreadTest {

    public static void main(String[] args) {

        NumberThread nt = new NumberThread();
        FutureTask futureTask = new FutureTask(nt);
        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
