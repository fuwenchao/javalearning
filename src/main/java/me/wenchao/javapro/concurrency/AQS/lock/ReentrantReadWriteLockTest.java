package me.wenchao.javapro.concurrency.AQS.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author wenchaofu
 * @DATE 17:24 2018/6/14
 * @DESC
 */
public class ReentrantReadWriteLockTest {
    private  Map<String, Data> map = new HashMap<>();
    private  ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();


    class Data{

    }

    private  Data  put(String key,Data value){
        writeLock.lock();
        try{
            return map.put(key, value);
        }finally {
            writeLock.unlock();
        }

    }
    private Data  get(String key){
        readLock.lock();
        try{
            return map.get(key);
        }finally {
            readLock.unlock();
        }

    }
    private Set<String> getAllKeys(){
        readLock.lock();
        try{
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }
    public static void main(String[] args) {



    }
}
