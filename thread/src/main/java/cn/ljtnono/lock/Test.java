package cn.ljtnono.lock;



public class Test {
    // 读写锁的测试
    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            demo.put("a", 10);

        }).start();
        new Thread(() -> {
            demo.put("b", 20);
        }).start();
        new Thread(() -> {
            demo.put("c", 30);
        }).start();
    }
}
