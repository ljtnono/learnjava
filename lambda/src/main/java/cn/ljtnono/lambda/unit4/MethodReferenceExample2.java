package cn.ljtnono.lambda.unit4;

public class MethodReferenceExample2 {

    public static void main(String[] args) {
        
        // MethodReferenceExample1::printMessage === () -> printMessage()
        Thread t = new Thread(MethodReferenceExample2::printMessage);
        t.start();

    }


    public static void printMessage() {
        System.out.println("Hello");
    }
}
