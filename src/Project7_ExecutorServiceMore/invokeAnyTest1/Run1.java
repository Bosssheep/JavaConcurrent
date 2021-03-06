package Project7_ExecutorServiceMore.invokeAnyTest1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * invokeA()将取得第一个完成任务的结果值，当第一个任务执行完成后，会调用interrupt()方法将其他任务中断。
 * 如果任务中通过if(Thread.currentThread.isInterrupted()==true)来判断任务是否继续运行。
 * 如果没有上述判断，则无法被中断
 * Run1未无中断判断的例子，虽然线程A已经获取了返回值，但线程B继续运行直到结束
 */
public class Run1 {
    public static void main(String[] args) {
        try{
            List  list = new ArrayList();
            list.add(new MyCallableA());
            list.add(new MyCallableB());

            ExecutorService executorService = Executors.newCachedThreadPool();
            String getValueA = (String) executorService.invokeAny(list);

            System.out.println("========="+getValueA);
            System.out.println("zzzzzzzzzzzzzzzzzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
