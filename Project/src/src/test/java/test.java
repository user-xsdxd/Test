import com.mapper.tb_student;
import object.sub.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

    @Test
    public void test(){
       Logger logger =  Logger.getLogger(test.class.getName());

//       logger.info("我是一个日志");
        logger.log(Level.SEVERE,"我是出现了严重错误");

    }

    @Test
//    查询所有
    public void testSelectAll() throws IOException {
        //        1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2.获取qlSessionFactory对象,用他来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        tb_student mapper = sqlSession.getMapper(tb_student.class);
        List<Student> students = mapper.selectAll();

        for (Student student : students) {
            System.out.println(student);
        }

//        释放资源
        sqlSession.close();
    }


    @Test
//    添加
    public void testAdd() throws IOException {
        //        1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2.获取qlSessionFactory对象,用他来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        tb_student mapper = sqlSession.getMapper(tb_student.class);

        String name = "作手新一";
        String sex = "男";
        int grade = 25;

        Student student = new Student();
        student.setSid(mapper.selectCount() + 2);
        student.setName(name);
        student.setSex(sex);
        student.setGrade(grade);

        mapper.add(student);

//        释放资源
        sqlSession.close();
    }


    @Test
//    查询人数
    public void testSelectCount() throws IOException {
        //        1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2.获取qlSessionFactory对象,用他来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        tb_student mapper = sqlSession.getMapper(tb_student.class);
        int i = mapper.selectCount();
        System.out.println(i);

//        释放资源
        sqlSession.close();
    }



    @Test
    //    删除信息
    public void testSelectId() throws IOException {
        Scanner sc = new Scanner(System.in);

        //        1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2.获取qlSessionFactory对象,用他来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        tb_student mapper = sqlSession.getMapper(tb_student.class);

        mapper.delete(4);
        List<Integer> list = mapper.selectId();
        int num = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) - num != 1){
                mapper.updateArr(num + 1,list.get(i));
                num++;
            }
            else{
                num = list.get(i);
            }
        }
//        释放资源
        sqlSession.close();

    }

    @Test
    //    修改信息
    public void testUpdate() throws IOException {
        Scanner sc = new Scanner(System.in);

        //1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2.获取qlSessionFactory对象,用他来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        tb_student mapper = sqlSession.getMapper(tb_student.class);

        System.out.println("请输入要修改的ID");
        int id = 7;
        List<Integer> list = mapper.selectId();
        if(list.size() >= id){
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
            mapper.update(id,student);
        }else {
            return;
        }
//        释放资源
        sqlSession.close();

    }
}
