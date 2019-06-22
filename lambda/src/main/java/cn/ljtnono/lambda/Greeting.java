package cn.ljtnono.lambda;

/**
 *  @author 凌家童
 *  @date 2019/6/22
 *  @version 1.0
 *
*/
// @FunctionalInterface   如果这里使用这个注解的话，那么将会报错，因为这个注解不允许接口有两个方法
public interface Greeting {

    void perform();

    void another();

}
