package org.example;

import com.mapper.tb_student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Colle {
    public static tb_student  coll(){
        //        1.加载mybatis的核心配置文件,获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        2.获取qlSessionFactory对象,用他来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        tb_student sql = sqlSession.getMapper(tb_student.class);
        return sql;
    }

//    时间
    public static String time(){
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        String[] split = time.toString().split("T");
        String[] split1 = split[1].toString().split(":");
        return split[0]+"  "+split1[0]+":"+split1[1];
    }

//    传递所有ID
//    public static ArrayList<Integer> ID(){
//
//    }
}
