package com.hebaohua.part1_advancedJava.day8;

import java.io.*;

/**
 * @author Hebh
 * @date 2018/1/27
 * @description:
 */
public class ObjectExam {
    public static void main(String[] args){
        Student s1 = new Student("John", 18, 5);
        System.out.println(s1);
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("obj.dat")
            );
            out.writeObject(s1);
            out.close();

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("obj.dat")
            );
            Student s2 = (Student)in.readObject();
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
class Student implements Serializable{
    private String name;
    private int age;
    private int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
