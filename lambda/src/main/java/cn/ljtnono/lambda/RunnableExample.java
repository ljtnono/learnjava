package cn.ljtnono.lambda;

/**
 *  @author 凌家童
 *  @date 2019/6/22
 *  @version 1.0
 *
*/
public class RunnableExample {

    public static void main(String[] args) {


        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });

        myThread.run();

        Thread myLambdaThread = new Thread(()->{
            System.out.println("Printed inside Runnable");
        });

        myLambdaThread.run();
    }
}
