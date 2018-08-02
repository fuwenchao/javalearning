package me.wenchao.javapro.concurrency.JUC;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author wenchaofu
 * @DATE 10:38 2018/6/20
 * @DESC
 */
@Slf4j
public class ForkJoinTaskTest extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 2;

    private int startNum;
    private int endNum;

    public ForkJoinTaskTest(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (endNum - startNum) <= THRESHOLD;
        if (canCompute) {
            for (;startNum  <= endNum; startNum++) {
                sum += startNum;
            }
        }else{
            int middleNum = (endNum + startNum )/2;
            ForkJoinTaskTest left = new ForkJoinTaskTest(startNum, middleNum);
            ForkJoinTaskTest right = new ForkJoinTaskTest(middleNum + 1, endNum);
            //执行子任务
            left.fork();
            right.fork();

            //等待任务结束

            Integer leftResult = left.join();
            Integer rightResult = right.join();

            sum = leftResult + rightResult;


        }


        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinTaskTest task = new ForkJoinTaskTest(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(task);
        log.info("result is in loginfo {}", result.get());
    }
}
