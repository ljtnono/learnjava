package cn.ljtnono.lambda;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 *  @author 凌家童
 *  @date 2019/6/22
 *  @version 1.0
 *
*/
public class Unit1Exercise {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Calyle", 51),
                new Person("Carlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // 1、根据lastName 来排序
        // 2、创建一个方法打印所有的信息
        // 3、创建一个方法打印所有lastName以C开头的人
        people.sort(Comparator.comparing(Person::getLastName));


        people.forEach(person -> {
            System.out.println(person);
        });

        System.out.println();
        people.forEach(person -> {
            if (person.getLastName().startsWith("C")) {
                System.out.println(person);
            }
        });
    }
}

