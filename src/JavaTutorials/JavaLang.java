package JavaTutorials;

public class JavaLang {
    // main方法参数必须为字符串数组(String [ ])，参数名可以不是args而是其它
    // 如果不这么写，就不能被系统识别为主方法
    // 有点类似必须得 if __name__ = '__main__' ?
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s);  // hello

        // String 本身也是一个class，定义的字符串实际上是 char[]
        String s2 = new String(new char[] {'z', 'h', 'a', 'n', 'g'});  // zhang
        System.out.println(s2);

        // String类的方法
        s2.contains("zh");  // true
        s2.indexOf("a");    // 2
        s2.lastIndexOf("g");    // 4
        s2.startsWith("z"); // true
        s2.endsWith("g");   // true

        // String类的其它方法，大同小异：isEmpty() / isBlank() / replace() / split() / join() / format()
        // format() 是比较老式的用法：%s 字符串占位；%d 整数占位；%x 十六进制整数占位；%f 浮点数占位符

        // 类型转换为 String，类似 str()
        String.valueOf(123);    // 被转换的数据，原类型可以是int/float/boolean/object

        // String <> Char 互相转换。String在JAVA里面是一个类，Char才是数据类型
        // char[] cs = string.toCharArray()
        // String s = new String(cs)
        char[] cs2 = s2.toCharArray();
        System.out.println(cs2);    // zhangwei
        String s3 = new String(cs2);
        System.out.println(s3);     // zhangwei
    }
}
