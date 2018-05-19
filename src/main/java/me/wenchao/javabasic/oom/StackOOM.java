package me.wenchao.javabasic.oom;

/**
 * @Author wenchaofu
 * @DATE 16:12 2018/5/17
 * @DESC
 * -Xss128K 限制栈容量
 */
public class StackOOM {

    private int statcLength = 1;
    public void stackLeak(){
        statcLength++;
        stackLeak();
    }

    public static void main(String[] args)  {
        StackOOM soom = new StackOOM();
        try {
            soom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack Length is " + soom.statcLength);
            throw e;
        }
    }

}
