package JavaTutorials;

import java.io.FileNotFoundException;

public class Exception {
    public static void main (String[] args) {
        System.out.println("class Exception");

        // 一个基础的异常处理
        try {
            String s = readFile("/path/to/file");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
            System.out.println(e);
        }

        // Throwable 异常体系的跟，包含了 Error 和 Exception

    }
}
