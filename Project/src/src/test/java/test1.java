import com.mapper.tb_student;
import object.sub.Book;
import object.sub.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Colle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class test1 {

//    添加书籍
    @Test
    public void testAdd(){
        tb_student sql = Colle.coll();
        System.out.println("请输入书名");
        String title = "缠论";
        System.out.println("请输入介绍");
        String desc = "情绪周期";
        System.out.println("请输入价格");
        double price = 59.34;

        Book book = new Book();
        book.setTitle(title);
        book.setDesc(desc);
        book.setPrice(price);
        book.setBid(sql.selectBootId() + 1);
        sql.AddBook(book);
    }

//    查询书籍
    @Test
    public void testselect(){
        tb_student sql = Colle.coll();
        List<Book> books = sql.selectBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

//    修改信息
    @Test
    public void testupdate(){
        tb_student mapper = Colle.coll();
        int id = 2;
        List<Integer> list = mapper.selectId();
        if (list.size() >= id) {
            System.out.print("原信息:");
            List<Book> book = mapper.selectByIdBook(id);
            System.out.println(book);
            Book book1 = new Book();
            System.out.println("请输入书名");
            book1.setTitle("传世投资");
            System.out.println("请输入介绍");
            book1.setDesc("市场善变,像空中的羽毛,如果你把命运托付给他,注定是个可怜虫");
            System.out.println("请输入价格");
            book1.setPrice(20.34);
            mapper.updateBook(id,book1);
        } else {
            System.out.println("该ID不存在");
            return;
        }
    }

    @Test
    public void testDelete(){
        tb_student mapper = Colle.coll();
        System.out.println("请输入学生id");
        int number = 2;
        mapper.DeleteBook(number);
        List<Integer> list = mapper.selectByBookId();
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - num != 1) {
                mapper.updateArrBook(num + 1, list.get(i));
                num++;
            } else {
                num = list.get(i);
            }
        }
    }

}

