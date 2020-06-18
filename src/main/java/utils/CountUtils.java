package utils;

import java.io.File;

public class CountUtils {
    public static void main(String[] args) {
        System.out.println(System.getenv());
        File file = new File("D:\\IdeaProjects\\algorithm_java\\src\\main\\java\\solution");
        final File[] files = file.listFiles();
        System.out.println(files.length);
    }
}
