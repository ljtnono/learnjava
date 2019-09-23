package cn.ljtnono.thread;

public class VolatileDemo1 {

    private int a = 1;

    public synchronized int getA() {
        return a;
    }

    public synchronized void setA(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

}
