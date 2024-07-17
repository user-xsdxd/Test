package org.example;

import com.mapper.tb_student;
import lombok.*;
import object.sub.Book;
import object.sub.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    private String name;
    private int grade;
    private String title;
    private Double price;
    private String time;

    @Override
    public String toString() {
        return
                "姓名:" + name +
                "  班级:" + grade +
                "  书名:" + title +
                "  价格:" + price +
                "  时间:" + time;
    }

    static tb_student coll = Colle.coll();
    static Scanner sc = new Scanner(System.in);
    public static void Main(){
        while (true){
            System.out.println("添加借阅信息");
            System.out.println("查询借阅信息");
            switch (sc.nextInt()){
                case 1 -> Library();
                case 2 -> show();
                case 0 -> {
                    return;
                }
                default -> System.out.println("输入错误");
            }
        }
    }

//    借书
    public static void Library(){
        List<Student> students = coll.BorrowByID();
        for (Student student : students) {
            System.out.println("ID:"+student.getSid() +"   "+"姓名"+student.getName());
        }
        System.out.println("请输入学生ID");
        int StudentId = sc.nextInt();
        if(StudentId > students.size()){
            System.out.println("该信息不存在");
            return;
        }else{
            List<Book> books = coll.selectBook();
            System.out.println("==== 书籍信息 ====");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println("请输入书籍ID");
            int bookId = sc.nextInt();
            if(bookId > books.size()){
                System.out.println("该书籍不存在");
                return;
            }else{
                LibraryID(bookId,StudentId);
            }
        }
    }

//    ID存在借书
    public static void LibraryID(Integer bid,Integer sid){
        List<Integer> list = coll.selectBookId();
        for (Integer integer : list) {
            if(integer == bid){
                System.out.println("该书已借出");
                return;
            }
            else {
                coll.InsertBook(list.size() + 1, sid,bid,Colle.time());
            }
        }
    }

//    查询借阅记录
    public static void show(){
        List<Borrow> borrows = coll.SelectBorrowingInformation();
        for (Borrow borrow : borrows) {
            System.out.println(borrow);
        }
    }
}
