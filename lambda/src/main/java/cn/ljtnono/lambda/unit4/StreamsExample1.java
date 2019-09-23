package cn.ljtnono.lambda.unit4;

import cn.ljtnono.lambda.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 *  @author 凌家童
 *  @date 2019/6/30
 *  @version 1.0
 *
*/
public class StreamsExample1 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Chales", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );
        Stream<Person> stream = people.stream();


    }

}
