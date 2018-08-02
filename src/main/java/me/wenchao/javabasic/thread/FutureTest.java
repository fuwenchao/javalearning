package me.wenchao.javabasic.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Author wenchaofu
 * @DATE 15:50 2018/6/1
 * @DESC
 */
class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "task number is " + id;
    }
}

public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));

        }
        for (Future<String> result : results) {
            try{
                System.out.println(result.get());
            }
            catch(InterruptedException e){
                e.printStackTrace();
                return;
            }
            catch(ExecutionException e){
                e.printStackTrace();

            }finally {
                executorService.shutdown();
            }

        }
    }



}
