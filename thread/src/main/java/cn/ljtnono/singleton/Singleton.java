package cn.ljtnono.singleton;

/**
 *  双重校验锁实现对象单例
 *  @author 凌家童
 *  @date 2019/9/22
 *  @version 1.0
 *
*/
public class Singleton {

    private volatile static Singleton instance;

    private  Singleton() {}

    public static Singleton getInstance() {
        // 如果实例已经创建，那么直接返回
        if (instance == null) {
             // 如果实例没有创建，那么执行创建
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;

    }
}
