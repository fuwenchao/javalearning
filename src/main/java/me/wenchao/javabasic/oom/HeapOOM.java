package me.wenchao.javabasic.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 15:47 2018/5/17
 * @DESC
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> oom = new ArrayList<OOMObject>();
        int count = 0 ;
        while(true){
            System.out.println(count++);
            oom.add(new OOMObject());
        }

    }
}
