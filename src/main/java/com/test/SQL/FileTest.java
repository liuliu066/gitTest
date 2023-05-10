package com.test.SQL;

import org.junit.Test;

import java.io.*;

/**
 * @author lwh
 * @description:
 * @date 2023/4/26 16:57
 */
public class FileTest {


    public static void main(String args[]) throws IOException {
        String filePath = "D:/eula.1028.txt";
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        while((strTmp = buffReader.readLine())!=null){
            System.out.println(strTmp);
        }
        buffReader.close();
    }





    @Test
    public void test() throws IOException{

        //1.读取文件
        File file = new File("d:/eula.1028.txt");
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");//考虑到编码格式
        BufferedReader bu = new BufferedReader(read);
        //2.拼接字符串
        String lineText = "";

        //3.边读边写
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(new File("d:/写出文件.txt")),"utf-8");
        BufferedWriter wr = new BufferedWriter(out);

        while((lineText = bu.readLine()) != null){
            System.out.println(lineText);
            wr.write(lineText+"\r\n");
        }
        read.close();
        wr.close();
    }


}




