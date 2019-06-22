package cn.ljtnono.lambda;

public  class DifferenceBetweenLambdaAndInterface implements Hi{

    public static void main(String[] args) {

        // lambda 表达式和接口的不同之处
        Hi h1 = new DifferenceBetweenLambdaAndInterface();
        Hi h2 = () -> System.out.println("hi");

        h1.hi();
        h2.hi();

        // 以上这两种得到的结果是一样的，但是主要来说lambda与接口的差别如下
        /**
         *  1、lambda只是一个变量，并不是一个接口的实现类，只能在一定范围内被复用
         *  2、当使用匿名内部类的时候，可以使用lambda来代替
         *
         *
         */

    }


    @Override
    public void hi() {
        System.out.println("hi");
    }
}


interface Hi {
    void hi();
}
