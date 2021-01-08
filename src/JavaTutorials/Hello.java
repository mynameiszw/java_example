package JavaTutorials;

public class Hello {
    public static void main(String [] args) {
        System.out.println("Hello world!"); // Hello world!

        int x = 1;
        System.out.println(x);  // 1
        x = 200;
        System.out.println(x);  // 200
        x = x + 100;
        System.out.println(x);  // 300

        Integer a = 1;
        System.out.println(a);  // 1
        String s = "zhangwei";
        System.out.println("my name is " + s);  // my name is zhangwei

        boolean isGreater = 5 > 3;  // true
        char c = '中';  // 一个unicode字符，用 '' 赋值，用 "" 赋值是String

        int[] ns = {1,2,3};
        System.out.println(ns[0]);  // 1

    }
}