package cn.ljtnono.lambda;

/**
 *  @author 凌家童
 *  @date 2019/6/30
 *  @version 1.0
 *
*/
public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
//        thisReferenceExample.doProcess(10, new Process() {
//            @Override
//            public void process(int i) {
//                System.out.println("Value of i is" + i);
//                System.out.println(this);  //  this指向 thisReferenceExample 这个对象
//            }
//
//            @Override
//            public String toString() {
//                return "This is the anonymous inner class";
//            }
//        });


        //下面两个this的值是一样的，

//        System.out.println(this);
        thisReferenceExample.doProcess(10, i -> {
            System.out.println("Value of i is " + i);
            // 在lambda中this的值和在lambda表达式外边的this值是一样的
//            System.out.println(this);
        });
    }

}
