package com.mapper;

import object.sub.Book;
import object.sub.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.Borrow;

import java.util.HashMap;
import java.util.List;

public interface tb_student {

    List<Student> selectAll();

//    查询学生人数
    @Select("select count(*) from tb_student;")
    int selectCount();

    //添加学生信息
    void add(Student student);

//    修改学生信息
    void update(@Param("id")int id,@Param("student")Student student);

//    删除学生信息
    void delete(int sid);
//    删除后更新
    void updateArr(@Param("num1")int num1,@Param("num2")int num2);
//    查询所有的ID
    @Select("select sid from tb_student;")
    List<Integer> selectId();


//    根据id查询个人信息
    @Select("select * from tb_student where sid = #{id}")
    List<Student> selectById(@Param("id")int id);


//    ======================================================
//    书籍
//    ======================================================



//
////    查询书籍数量
    @Select("select count(bid) from tb_boot")
    int selectBootId();

//    添加书籍
    @Insert("insert into tb_boot (title,`desc`,price) values (#{title},#{desc},#{price});")
    void AddBook(Book book);

//    查看所有书籍
    @Select("select * from tb_boot")
    List<Book> selectBook();

//    修改书籍信息
    void updateBook(@Param("id")int id,@Param("book")Book book);

    //    根据id查询书籍信息
    @Select("select * from tb_boot where bid = #{id}")
    List<Book> selectByIdBook(@Param("id")int id);

//    查询所有书籍的ID
    @Select("select bid from tb_boot")
    List<Integer> selectByBookId();

//    删除后更新
    void updateArrBook(@Param("num1")int num1,@Param("num2")int num2);
//    删除书籍
    @Delete("delete from tb_boot where bid = #{id}")
    void DeleteBook(@Param("id")int id);


//    ========================================
//    借阅系统

//    查询学生ID及姓名
    @Select("select sid,name from tb_student")
    List<Student> BorrowByID();

//    查询借出书的ID
    @Select("select bid from manage")
    List<Integer>  selectBookId();

//    添加书籍
    void InsertBook(@Param("id")int id,@Param("sid")int sid,@Param("bid")int bid,@Param("time")String time);


//    借阅记录
    List<Borrow> SelectBorrowingInformation();


}
