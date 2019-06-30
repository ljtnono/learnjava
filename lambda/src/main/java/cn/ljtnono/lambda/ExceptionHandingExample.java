package cn.ljtnono.lambda;

import java.util.function.BiConsumer;

/**
 *  @author 凌家童
 *  @date 2019/6/30
 *  @version 1.0
 *
*/
public class ExceptionHandingExample {

    public static void main(String[] args) {
        int [] someNumbers = {1,2,3,4};
        int key = 2;
        process(someNumbers, key, wrapperLambda((v, k) -> {
            System.out.println(v / k);
        }));
    }

    // BiConsumer 这个接口表示 接收两个参数的
    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
            consumer.accept(i,key);
        }
    }


    // 推荐的异常处理的方式
    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v,k) -> {
           try {
               consumer.accept(v, k);
           } catch (ArithmeticException e) {
               System.out.println("Exception caught in wrapper lambda");
           }
        };
    }
}
