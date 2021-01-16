package JavaTutorials;

public class LearnClass {
    public static void main(String[] args) {

        Person me = new Person("zhangwei", 32);
        Person girl = new Person("beauty girl", 23);
        me.getName();   // zhangwei
        me.getAge();    // 32
        girl.getName(); // beauty girl
        girl.getAge();  // 23

        // 下面创建 student 实例会报错，因为无法传递 name 和 age
        // 而创建时会调用父类 Person 的 default constructor 即 Person()
        // Student zjm = new Student(1, 100);

        // 应该在 Student 构建器中加入父类的参数 name 和 age，并通过 super(name, age) 完成父类的构造
        Student zjm = new Student("zhangjm", 4, 16, 100);
        zjm.getName();  // zhangjm
        zjm.getScore(); // 100

        // 下面这种方式是允许的。向上/向下转型
        // Person p = new Student()

    }
}

class Person {
    // private 无法被继承，以 protected 代替
    // private String name;
    // private int age;
    protected String name;
    protected int age;

    // default constructor, 要写构建器时，必须要准备无任何参数的默认构建器，否则继承时会出错
    Person() {
        throw new IllegalArgumentException("invalid constructor value");
    }

    // 实际的构建器
    Person(String name, int age) {
        checkAge(age);
        this.name = name;
        this.age = age;
        System.out.println("Create Person " + name + ". Age is " + age);
    }

    public String getName() {
        System.out.println(this.name);
        return this.name;
    }

    public int getAge() {
        System.out.println(age);
        return this.age;
    }

    // private method 只能内部调用
    private void checkAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
    }
}

class MethodOverload {
    public void overload() {
        System.out.println("overload-1");
    }

    // 重名method，使用传参区分。还有其它不同的优先级，区分方式。
    // TODO:? 什么场景会用到同名method，这样的设计初衷是什么呢...?
    public void overload(String arg) {
        System.out.println("overload-" + arg);
    }
}

class Student extends Person {
    // 继承
    private int id;
    private int score;

    // 鉴于子类无法访问父类的 private 数据，要重写 name 和 age，改 private 为 protected

    // 构建参数加上父类的两个参数 name 和 age, 并使用super(name, age)方法调用父类构造器
    Student(String name, int age, int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public int getId() {
        System.out.println(this.id);
        return this.id;
    }

    public int getScore() {
        System.out.println(this.score);
        return this.score;
    }

    @Override // Compile error! 加上 @Override 让编译器检查覆写的方法是否正确，异常会在编译期抛出
    public String getName() {
        System.out.println("覆写父类的 getName 方法：" + this.name);
        return this.name;
    }
}

// 到目前为止，java&python思路都是大同小异。包括 this <> self, private <> __method, super <> super, constructor <> __init__

// abstract 用来声明一个抽象的对象/方法，有这个名字，但实际啥也没有
// 只能用来被继承，实际啥也干不了
abstract class AbstractClass {
    public abstract void absctractMethod();
}

// interface 接口，若抽象类没有字段，可以改写为接口
// 接口定义的所有方法默认都是 public abstract
// 接口要被继承，需要使用 implements 例如 class Student implements Person {}
// 一个类只可以继承（extends）一个父类，但可以实现（implements）多个interface
// 一个interface只可以继承（extends）另一个interface
interface InterfacePerson {
    void run();
    String getName();

    //TODO: ? 若接口新增的是 default 方法，子类不必全部修改。若非 default 方法，会涉及到修改全部子类，不太理解了 ?
    default void defaultMethod() {
        System.out.println("Do Something");
    }
}

// 廖雪峰的教程，浅显，好入手；Thinking in Java 较难但是全面

// static，独立的内存空间。静态方法和静态变量可以在 不创建实例 的情况下调用
// 例如 类名.静态变量名，类名.静态方法名。可以说跟 Python 的 @staticmethod 是类似的思路

// 目录是包名，文件名是类名

// 作用域
// public：被任意访问
// private：在类 class 中任意访问
// protected：可以被子类访问，用以继承
// {}：括号内的变量无法在外部引用
// final：禁止继承 public final class Person {}；禁止被覆写 protected final void run() {}；禁止被重新赋值 private final int n = 0


