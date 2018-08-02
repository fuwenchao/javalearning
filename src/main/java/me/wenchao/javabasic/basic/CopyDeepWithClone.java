package me.wenchao.javabasic.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Author wenchaofu
 * @DATE 10:51 2018/6/21
 * @DESC
 */
/* clone方法实现浅拷贝 */
public class CopyDeepWithClone {
    public static void main(String[] args) {
        Age2 a=new Age2(20);
        Student2 stu1=new Student2("wenchao1",a,175);

        //通过调用重写后的clone方法进行浅拷贝
        Student2 stu2=(Student2)stu1.clone();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());

        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("changedName");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        //stu1.setaAge(new Age(99));    使用这种方式修改age属性值的话，stu2是不会跟着改变的。因为创建了一个新的Age类对象而不是改变原对象的实例值
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }
}

/*
 * 创建年龄类
 */
@Data
@ToString
@AllArgsConstructor
class Age2 implements Cloneable{
    private int age;

    //重写Object类的clone方法
    @Override
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法，返回一个Object实例
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

/*
 * 创建学生类
 */
@Data
@ToString
@AllArgsConstructor
class Student2 implements Cloneable{
    //学生类的成员变量（属性）,其中一个属性为类的对象
    private String name;
    private Age2 age;
    private int length;


    //重写Object类的clone方法
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法，返回一个Object实例
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Student2 stu2 = (Student2) obj;
        stu2.age = (Age2)stu2.getAge().clone();
        return obj;
    }
}