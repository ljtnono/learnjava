package cn.ljtnono.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *  @author 凌家童
 *  @date 2019/6/29
 *  @version 1.0
 *
*/
public class UnitExerciseSolutionJava8 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Chales", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );
        // 根据lastName进行排序
        Collections.sort(people,(p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        System.out.println("Printing all persons");
        printConditionally(people, p -> true, p -> System.out.println(p));
        // 创建一个函数，打印所有people 中last name 以C开头的
        printConditionally(people, p -> p.getLastName().startsWith("C"),  p -> System.out.println(p));
        // 创建一个函数，打印所有first name 以 C 开头的people
        printConditionally(people, p -> p.getFirstName().startsWith("C"),  p -> System.out.println(p));

    }

    // Predict 接口是 java.util.function包中的一个接口，开箱即用的lambda表达式创建
    // predict 接口  接收一个参数，调用 test函数返回一个boolean值
    // Consumer 接口 接收一个参数，调用accept函数 返回值为void 的函数
    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> success) {
        for (Person p : people) {
            if (predicate.test(p)) {
                success.accept(p);
            }
        }
    }


}
