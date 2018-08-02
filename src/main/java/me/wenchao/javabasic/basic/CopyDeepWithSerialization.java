package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 11:13 2018/6/21
 * @DESC
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 通过序列化实现深拷贝 */
public class CopyDeepWithSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        Age3 a=new Age3(20);
        Student3 stu1=new Student3("wenchaofu",a,175);
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(stu1);
        oos.flush();
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Student3 stu2=(Student3)ois.readObject();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println();
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("chanedName");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
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
class Age3 implements Serializable{
    //年龄类的成员变量（属性）
    private int age;
}
/*
 * 创建学生类
 */
@Data
@AllArgsConstructor
@ToString
class Student3 implements Serializable{
    //学生类的成员变量（属性）,其中一个属性为类的对象
    private String name;
    private Age3 aage;
    private int length;
}