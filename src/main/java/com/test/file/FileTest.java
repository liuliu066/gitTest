package com.test.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author lwh
 * @date 2021/10/14 15:44
 */
public class FileTest {

    /*
     - File的构造函数
     - */
    @Test
    public void test01() {
        //File(String pathname)  将指定路径名转换成一个File对象
        File file = new File("D:\\1.txt");
        System.out.println(file);
        //File(String parent,String child) 根据指定的父路径和文件路径创建File对象
        File file1 =  new File("D:\\a","1.txt");
        System.out.println(file1);
        //File(File parent,String child) 根据指定的父路径对象和文件路径创建File对象
        File parent = new File("D:\\a");
        File file2 = new File(parent, "1.txt");
        System.out.println(file2);
        File file3 = new File(new File("D:\\a"),"1.txt");
        System.out.println(file3);

    }


    @Test
    public void test02() throws IOException {
        File file = new File("D:\\a\\1.txt");
        File file1 = new File("1.txt");
        boolean flag = file1.createNewFile();
        System.out.println(flag);

        File file2 = new File("b");
        boolean flag2 = file2.mkdir();
        System.out.println(flag);

        File file3 = new File("c\\d\\e");
        boolean d = file1.mkdir();
        boolean c = file1.mkdirs();
        System.out.println(d);
        System.out.println(c);
        File file4 = new File("c.txt");
        System.out.println(file4.mkdir());

        File file5 = new File("b");
        System.out.println(file2.delete());

    }

}
