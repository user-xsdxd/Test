package object.sub;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int sid;
    private String name;
    private String sex;
    private int grade;


    @Override
    public String toString() {
        return
                "ID:" +sid+
                "  姓名:" +name+
                "  性别:" +sex+ "  年龄:" + grade ;
    }
}
