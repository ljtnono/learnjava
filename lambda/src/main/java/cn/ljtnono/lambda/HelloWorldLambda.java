package cn.ljtnono.lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

public class HelloWorldLambda {


    public static void main(String[] args) {

        // 定义一个lambda表达式
        // 这里lambda 可以使用Runnable 接口来接收作为变量使用,但是如果lambda有了参数之后就变的不一样了
        Runnable greetingFunction = () -> System.out.println("Hello world!");

        // 定义一个doubleNumberFunction
        // IntFunction<a> 表示接收一个int类型参数，并返回int类型值
        IntFunction<Integer> doubleNumberFuction = (int a) -> a * 2;

        // IntBinaryOperator 表示接收两个int类型的参数，并返回int类型的参数
        IntBinaryOperator addFunction = (int a, int b) -> a + b;

        //safeDivideFunction
        //IntBinaryOperator 表示接收两个int类型的参数，并返回int类型的参数
        IntBinaryOperator safeDivideFunction = (int a, int b) -> {
            if (b == 0) {
                return 0;
            } else {
                return a / b;
            }
        };

        // Function<a, b> 表示参数为a类型，返回值为b类型的lambda表达式
        Function<String, Integer> stringLengthCountFunction = (String s) -> s.length();
        // 如果使用自己定义的类作为参数的话，那么jdk不可能为我们提供lambda的相关类型
        // 我们可以使用自定义的接口来作为lambda表达式的类型

        HelloWorld h = (HelloWorldLambda helloWorldLambda) -> System.out.println("hello world！");
        // 使用instanceof 可以判断lambda表达式的类型
        System.out.println(h instanceof HelloWorld);
        // 使用接口中的方法来调用具体lambda表达式
        h.hello(new HelloWorldLambda());

    }
}

interface HelloWorld {
    void hello(HelloWorldLambda helloWorldLambda);
}
