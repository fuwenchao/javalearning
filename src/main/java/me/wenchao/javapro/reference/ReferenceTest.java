package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:08 2018/5/15
 * @DESC
 */
public class ReferenceTest {

    private static final  int _1M = 1024 * 1024;


    /** Creates a new instance of ReferenceTest */
    public ReferenceTest() {
    }

    // 消耗大量内存
    public static void drainMemory() {
        System.out.println("begin to allocation memory");
        String[] array = new String[1024 * 10];
        for(int i = 0; i < 1024 * 10; i++) {
            for(int j = 'a'; j <= 'z'; j++) {
                array[i] += (char)j;
            }
        }
//        byte[] m1 = new byte[_1M * 10];
        System.out.println("end allocation memory");
    }
}