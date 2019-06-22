package cn.ljtnono.lambda;
/**
 *  @author 凌家童
 *  @date 2019/6/22
 *  @version 1.0
 *
*/
public class UsingFunctionalInterfaceAnnotation {




}

// 使用@FunctionalInterface 注解可以在编译器编译的时候检查
@FunctionalInterface
interface Hello {
    void hello();

    default void ss() {

    }
}
