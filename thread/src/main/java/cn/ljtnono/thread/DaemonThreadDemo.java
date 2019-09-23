package cn.ljtnono.thread;

/**
 *  守护线程测试
 *  @author 凌家童
 *  @date 2019/9/21
 *  @version 1.0
 *
*/
public class DaemonThreadDemo {

    static volatile int number = 0;
    /**
     * 需求：设置一个守护线程，当a > 1000 条件的时候重新启动线程
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程每过1秒加1，加到一千之后停止

        Thread countThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (number < 0) {
                        number ++;
                        System.out.println("number = " + number);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 计数线程存活
                while (true) {
                    if (number >= 0) {
                        number--;
                        System.out.println("number = " + number);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        countThread.start();
        daemonThread.setDaemon(true);
        daemonThread.start();
        countThread.join();
    }
}
