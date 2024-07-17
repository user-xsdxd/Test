package org.example;

import com.mapper.tb_student;
import object.sub.Student;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GB_Student {
    static Scanner sc = new Scanner(System.in);

    public static void Main() throws IOException {
        tb_student sql = Colle.coll();
        while (true) {
            System.out.println("1 ---- 添加学生信息");
            System.out.println("2 ---- 删除学生信息");
            System.out.println("3 ---- 查询学生信息");
            System.out.println("4 ---- 修改学生信息");
            System.out.println("5 ---- 退出");
            System.out.println();
            int index = sc.nextInt();
            switch (index) {
                case 1 -> add(sql);
                case 2 -> delete(sql);
                case 3 -> select(sql);
                case 4 -> update(sql);
                case 0 -> {
                    return;
                }
                default -> System.out.println("请输入正确的指令");

            }
        }
    }


    //    添加信息
    public static void add(tb_student mapper) throws IOException {
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入性别");
        String sex = sc.next();
        System.out.println("请输入年龄");
        int grade = sc.nextInt();
        Student student = new Student();
        student.setSid(mapper.selectCount() + 1);
        student.setName(name);
        student.setSex(sex);
        student.setGrade(grade);
        mapper.add(student);
    }

    //    删除信息
    public static void delete(tb_student mapper) {
        System.out.println("请输入学生id");
        int number = sc.nextInt();
        mapper.delete(number);
        List<Integer> list = mapper.selectId();
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - num != 1) {
                mapper.updateArr(num + 1, list.get(i));
                num++;
            } else {
                num = list.get(i);
            }
        }
    }


    //    查询所有
    public static void select(tb_student mapper) {
        List<Student> students = mapper.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //    修改信息
    public static void update(tb_student mapper) {
        System.out.println("请输入要修改的ID");
        int id = sc.nextInt();
        List<Integer> list = mapper.selectId();
        if (list.size() >= id) {
            System.out.print("原信息:");
            List<Student> students = mapper.selectById(id);
            System.out.println(students);
            Student student = new Student();
            System.out.println("请输入姓名");
            student.setName(sc.next());
            System.out.println("请输入性别");
            student.setSex(sc.next());
            System.out.println("请输入年龄");
            student.setGrade(sc.nextInt());
            mapper.update(id, student);
        } else {
            System.out.println("该ID不存在");
            return;
        }
    }

}

