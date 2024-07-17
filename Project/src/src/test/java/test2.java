import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class test2 {
    public static final Logger LOGGER = LoggerFactory.getLogger("LogbackTest");


    static Scanner sc = new Scanner(System.in);
    static Properties properties = new Properties();

    @Test
    public void test(){
        System.out.println(1);
        LOGGER.info("执行了1");
        System.out.println(2);
        LOGGER.info("执行了2");
    }

    @Test
    public void test1() throws IOException {
//        1.创建一个properties对象出来
        Properties properties = new Properties();
//        2.开始加载属性文件中的键值对数据到properties中去
        properties.load(new FileReader("F:\\Dome\\Project\\src\\src\\main\\resources\\user.properties"));

//        System.out.println(properties);

//        遍历全部键和值
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            String value = properties.getProperty(key);
            System.out.println(key +"  "+ value);
        }

//        把键值对数据存入到属性文件中
//        properties.setProperty()

    }

@Test
    public void test2() throws IOException {
    System.out.println("请输入用户名");
    String name = "张三";
    System.out.println("请输入密码");
    String password = "23456";
    properties.load(new FileReader("F:\\Dome\\Project\\src\\src\\main\\resources\\user.properties"));
    Set<String> Key = properties.stringPropertyNames();
    for (String key : Key) {
        String value = properties.getProperty(key);
        if(name.equals(key)){
            System.out.println("该用户名已存在");
            return;
        }else{
            System.out.println("注册成功");
            properties.setProperty(name,password);
            properties.store(new FileWriter("F:\\Dome\\Project\\src\\src\\main\\resources\\user.properties"),"My Users");

        }
    }

}
}
