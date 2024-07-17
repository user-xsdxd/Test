package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Login {
    static Scanner sc = new Scanner(System.in);
    static Properties properties = new Properties();
    //记录日志
    public static final Logger LOGGER = LoggerFactory.getLogger("LogbackTest");

    public static void login() throws IOException {

    }

    public static void Main() throws IOException {
        while (true){
            System.out.println("1 ---- 登录");
            System.out.println("2 ---- 注册");
            System.out.println("3 ---- 退出");
            switch (sc.nextInt()) {
                case 1 -> logon();
                case 2 -> enroll();
                case 0 -> {
                    return;
                }
                default -> System.out.println("请输入正确的指令");
            }
        }
    }

    //登录
    public static void logon() throws IOException {
        System.out.println("请输入用户名");
        String name = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        properties.load(new FileReader("F:\\Dome\\Project\\src\\src\\main\\resources\\user.properties"));
        Set<String> Key = properties.stringPropertyNames();
        for (String key : Key) {
            String value = properties.getProperty(key);
            if(name.equals(key) && value.equals(password)){
                System.out.println("登陆成功");
                Page.page();
            }

        }
        return;
    }

    //注册
    public static void enroll() throws IOException {
        System.out.println("请输入用户名");
        String name = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        properties.load(new FileReader("F:\\Dome\\Project\\src\\src\\main\\resources\\user.properties"));
        Set<String> Key = properties.stringPropertyNames();
        for (String key : Key) {
            String value = properties.getProperty(key);
            if(name.equals(key)){
                System.out.println("该用户名已存在");
                return;
            }
        }
        System.out.println("注册成功");
        properties.setProperty(name,password);
        properties.store(new FileWriter("F:\\Dome\\Project\\src\\src\\main\\resources\\user.properties"),"My Users");
    }
}
