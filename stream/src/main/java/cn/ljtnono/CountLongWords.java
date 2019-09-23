package cn.ljtnono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {

    public static void main(String[] args) throws IOException {
        // 使用Files中的readAllBytes读取文件内容，返回byte[]类型，然后将其中的
        String contents = new String(Files.readAllBytes(Paths.get("stream/target/classes/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) {
                count++;
            }
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);

    }
}
