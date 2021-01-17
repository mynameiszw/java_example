package JavaTutorials;

import java.util.StringJoiner;

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

        // char 是两个字节的 unicode 编码，编码转换方式为
        byte[] b1 = s2.getBytes();  // 不填按系统默认编码转换，或者填写 UTF-8 / GBK 等等

        // StringBuilder 用于字符串拼接的类，线程安全的哦
        StringBuilder sb = new StringBuilder(1024); // length
        sb.append("wei");
        // 下面这个叫 链式操作
        sb.insert(0, "zhang")
          .append("。");
        String s4 = sb.toString();
        System.out.println(s4); // zhangwei。

        // StringJoiner = join，用分隔符频姐数组
        String[] line = {"my", "name", "is", "zhangwei"};
        var sj = new StringJoiner(" ");
        for (String item: line) {
            sj.add(item);
        }
        System.out.println(sj.toString());  // my name is zhangwei
        // 或者更简单的 String.join() 方法
        var s5 = String.join(" ", line);    // my name is zhangwei

        // 包装类型，通过类封装的形式，允许在初始化变量时赋值为 null
        // 所有的数据类型都有对应的包装类型：java.lang.*
        // 包装类型一旦创建，不可修改（不可重现赋值），也叫不变类

        // AutoBoxing，语法直接允许包装类和数据类型互换
        int i = 100;
        Integer n1 = Integer.valueOf(i);
        int x1 = n1.intValue();   // 100
        // 下面是一样效果的语句
        Integer n2 = 100;   // 自动 valueOf
        int x2 = n2;    // 自动 intValue()


    }
}
