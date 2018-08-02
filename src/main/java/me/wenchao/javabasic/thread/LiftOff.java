package me.wenchao.javabasic.thread;

/**
 * @Author wenchaofu
 * @DATE 10:25 2018/6/1
 * @DESC
 */
public class LiftOff implements Runnable{
    protected  int countDowm = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){

    }
    private  LiftOff(int countDown){
        this.countDowm = countDown;
    }
    private String status(){
        return "#" + id + "(" +
                (countDowm>0 ? countDowm : "LiftOff!") + ")";
    }
    @Override
    public void run(){
        System.out.println("in running .. ");
/*        while(countDowm-- > 0){
            System.out.println(status());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread.yield();
        }*/
    }

    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
//        Thread thread = new Thread(liftOff);
//        thread.start();
        System.out.println("+++++++++++");
//        thread.start();
        liftOff.run();
        liftOff.run();
//        liftOff.start();
//        liftOff.start();
//        new LiftOff().start();
//        new LiftOff().start();
        System.out.println("------------");
//        liftOff.run();
    }
}
