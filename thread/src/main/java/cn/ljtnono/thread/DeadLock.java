package cn.ljtnono.thread;

/**
 *  死锁的例子
 *  @author 凌家童
 *  @date 2019/9/22
 *  @version 1.0
 *
*/
public class DeadLock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {
        // 创建两个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "is running!");
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + "is running!");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "is running!");
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + "is running!");
                    }
                }
            }
        }).start();
        while(true) {

        }
    }
}
