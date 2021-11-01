package com.test.file;

import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author lwh
 * @date 2021/10/15 9:33
 */
public class FileReadFunction {
    public static void main(String[] args) throws IOException {

        String a = "";
        ClassPathResource classPathResource = new ClassPathResource("/file/FileWrite_test.txt");
        // 获得File对象，当然也可以获取输入流对象
        File file = classPathResource.getFile();
        FileReader fr = new FileReader(file);
        //这样每次read读取一个字符，直到-1为止,这种方法不可取
        //        while(fr.read() != -1){
        //            System.out.println(fr.read());
        //        }
        int ch;
        //这样写可以防止最后取值到-1的情况
        while ((ch = fr.read()) != -1) {
        //流 fr 的 read() 方法从流中抠出一个字节返回，如果抠到流末尾，则返回 -1 。
        //  为什么用 -1 因为一个字节的取值范围是 0 到 255，先遣们喜欢用 -1 表示特殊值
        //System.out.print((char) ch);    //char就可以把原本是数字的文件翻译回来
            char b = (char) ch;
        // 虽然这个方法很简单，但这是效率最低的方法
        // Java中的String Object的值实际上是不可变的，是一个final的变量。
        // 所以我们每次对String做出任何改变，都是初始化了一个全新的String Object并将原来的变量指向了这个新String。
        // 而Java对使用+运算符处理String相加进行了方法重载。
        // 字符串直接相加连接实际上调用了如下方法：
        // new StringBuilder().append("").append('c').toString();
            a = a + b;
        }
        fr.close();

        System.out.println(a);
        //数组自定长度一次性读取
        FileReader fr2 = new FileReader(file);
        char[] buf = new char[6];
        int len;
        while ((len = fr2.read(buf)) != -1) {
            String str = new String(buf, 0, len);
//             System.out.print(str);
        }

    }
}