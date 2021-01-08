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
}

// 到目前为止，java&python思路都是大同小异。包括 this <> self, private <> __method, super <> super, constructor <> __init__

// TODO: https://www.liaoxuefeng.com/wiki/1252599548343744/1260454548196032