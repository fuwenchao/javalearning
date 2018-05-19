package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 9:15 2018/5/18
 * @DESC
 * -XX:MaxPermSize=10k
 */
public class PermOOM {
    public static void main(String[] args) {
        int i = 0;
        while(true){
            String str = new String ("abc");
            i++;
            if(i > 1000000) break;
        }
        System.out.println("out of memory" + i);
    }
}
