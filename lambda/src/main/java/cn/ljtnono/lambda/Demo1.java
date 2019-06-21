package cn.ljtnono.lambda;

public class Demo1 {

    public static void main(String[] args) {

        Runnable helloWorld = () -> System.out.println("hello world");



        helloWorld.run();

    }



}
