import com.mapper.tb_student;
import object.sub.Student;
import org.example.Borrow;
import org.example.Colle;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class test3 {
    static tb_student coll = Colle.coll();

//    时间
    @Test
    public void testSelect() throws ParseException {
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        String[] split = time.toString().split("T");
        String[] split1 = split[1].toString().split(":");
        System.out.println(split[0]+"  "+split1[0]+":"+split1[1]);
    }

    @Test
    public void test1(){
        List<Student> students = coll.BorrowByID();
        for (Student student : students) {
            System.out.println("ID:"+student.getSid() +"   "+"姓名"+student.getName());
        }
        System.out.println("请输入学生ID");
    }

    @Test
    public void test2(){
//        coll.InsertBook(3,4,2,"2024-06-16  14:50");
        System.out.println(Colle.time());
        List<Borrow> borrows = coll.SelectBorrowingInformation();
        for (Borrow borrow : borrows) {
            System.out.println(borrow);
        }


        }


}

