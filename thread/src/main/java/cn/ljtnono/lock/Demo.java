package cn.ljtnono.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo {

    private Map<String, Object> map = new HashMap<>();
    // 读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 分别获取读锁和写锁
    private Lock r = readWriteLock.readLock();
    private Lock w = readWriteLock.writeLock();


    public Object get(String key) {
        r.lock();
        System.out.println(Thread.currentThread().getName() + "读操作正在进行。。。");

        try {
            Thread.sleep(3000);
            return map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName() + "读操作执行完毕。。。");
        }
        return map.get(key);
    }

    public void put(String key, Object value) {
        w.lock();
        System.out.println(Thread.currentThread().getName() + "写操作正在进行。。。");
        try {
            Thread.sleep(3000);
            map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName()+ " 写操作执行完毕");
        }
    }
}
