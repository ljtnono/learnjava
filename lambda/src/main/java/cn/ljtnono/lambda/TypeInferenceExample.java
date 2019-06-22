package cn.ljtnono.lambda;

/**
 *
 *  @author 凌家童
 *  @date 2019/6/22
 *  @version 1.0
 *
*/
public class TypeInferenceExample {


    // 接收一个StringLengthLambda类型的参数，并且调用这个接口的实现函数
    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getLength("Hello Lambda"));
    }


    public static void main(String[] args) {
        printLambda(s -> s.length());
    }

    // 定义一个接口用来接收lambda表达式类型
    interface StringLengthLambda {
        int getLength(String s);
    }

}
