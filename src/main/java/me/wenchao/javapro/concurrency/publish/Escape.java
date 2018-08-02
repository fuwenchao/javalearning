package me.wenchao.javapro.concurrency.publish;

import me.wenchao.annotation.NotThreadSafe;

/**
 * @Author wenchaofu
 * @DATE 11:52 2018/6/13
 * @DESC
 */
@NotThreadSafe
public class Escape {
    private int thisCanbeEscape = 0;
    public Escape(){
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
            System.out.println(Escape.this.thisCanbeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
