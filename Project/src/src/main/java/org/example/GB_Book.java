package org.example;

import com.mapper.tb_student;
import object.sub.Book;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class GB_Book {
    static Scanner sc = new Scanner(System.in);
    public static void Main(){
        tb_student coll = Colle.coll();
        while(true){
            System.out.println("1 ---- 添加书籍");
            System.out.println("2 ---- 查看书籍");
            System.out.println("3 ---- 修改书籍");
            System.out.println("4 ---- 删除书籍");
            int number = sc.nextInt();
            switch (number){
                case 1 -> add(coll);
                case 2 -> select(coll);
                case 3 -> update(coll);
                case 4 -> delete(coll);
                case 0 -> {
                    return;
                }
                default -> System.out.println("请输入正确的指令");

            }
        }
    }

//    添加书籍
    public static void add(tb_student sql){
        System.out.println("请输入书名");
        String title = sc.next();
        System.out.println("请输入介绍");
        String desc = sc.next();
        System.out.println("请输入价格");
        double price = sc.nextDouble();

        Book book = new Book();
        book.setTitle(title);
        book.setDesc(desc);
        book.setPrice(price);
        book.setBid(sql.selectBootId() + 1);
        sql.AddBook(book);
    }

//    查看书籍
    public static void select(tb_student sql){
        List<Book> books = sql.selectBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

//    修改书籍
    public static void update(tb_student sql){
        System.out.println("请输入要修改书籍的ID");
        int id = sc.nextInt();
        List<Integer> list = sql.selectId();
        if (list.size() >= id) {
            System.out.print("原信息:");
            List<Book> book = sql.selectByIdBook(id);
            System.out.println(book);
            Book book1 = new Book();
            System.out.println("请输入书名");
            book1.setTitle(sc.next());
            System.out.println("请输入介绍");
            book1.setDesc(sc.next());
            System.out.println("请输入价格");
            book1.setPrice(sc.nextDouble());
            sql.updateBook(id,book1);
        } else {
            System.out.println("该ID不存在");
            return;
        }
    }

//    删除信息
    public static void delete(tb_student sql){
        System.out.println("请输入学生id");
        int number = 2;
        sql.DeleteBook(number);
        List<Integer> list = sql.selectByBookId();
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - num != 1) {
                sql.updateArrBook(num + 1, list.get(i));
                num++;
            } else {
                num = list.get(i);
            }
        }
    }
}
