package cn.ljtnono.lambda;

public class ClosuresExample {


    public static void main(String[] args) {
        int a = 10;
        int b = 20;
//        如果使用的匿名内部类的方式，当访问外部变量的时候需要声明为final类型的
//        doProcess(a, new Process() {
//            @Override
//            public void process(int i) {
//                b = 40;
//                System.out.println(i);
//            }
//        });

        // 以下写法是正常的
        // doProcess(a, i -> System.out.println(i + b));
        // 以下写法错误
//        doProcess(a, i -> {
//            b = 40;
//            System.out.println(b);
//        });
    }


    public static void doProcess(int i, Process p ) {
        p.process(i);
    }

}


interface Process {
    void process(int i);
}
