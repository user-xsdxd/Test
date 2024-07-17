package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Page {
    public static void page() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1 ---- 学生信息");
            System.out.println("2 ---- 图书信息");
            System.out.println("3 ---- 借阅记录 ===== 制作中");
            System.out.println("4 ---- 退出");
            switch (sc.nextInt()){
                case 1 -> GB_Student.Main();
                case 2 -> GB_Book.Main();
                case 3 -> Borrow.Main();
                case 0 -> {
                    return;
                }
                default -> System.out.println("请输入正确的指令");
            }
        }
    }
}