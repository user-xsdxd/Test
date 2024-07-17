package object.sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bid;
    private String title;
    private String desc;
    private double price;

    @Override
    public String toString() {
        return
                "ID:" + bid +
                " 书名:" + title +
                " 介绍:" + desc +
                " 价格:" + price
                ;
    }
}
