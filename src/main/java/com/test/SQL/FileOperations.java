package com.test.SQL;

/**
 * @author lwh
 * @description:
 * @date 2023/4/26 17:10
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {

    public static void main(String[] args) {
        try {
            // 读取文件
            File inputFile = new File("d:/data/S1_1xi0.9-Cloud.txt");
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // 写入文件
            File outputFile = new File("d:/data/S1_1xi0.9-CloudLast.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // 对每一行进行处理
                String processedLine = processLineLast(line);

                // 将处理后的行写入新文件
                fileWriter.write(processedLine);
                fileWriter.write("\n"); // 写回车符

            }

            // 关闭输入和输出流
            bufferedReader.close();
            fileReader.close();
            fileWriter.close();
            System.out.println("over");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据空格拆分
     * @param line
     * @return
     */
    private static String processLine(String line) {

        // 根据空格拆分
        String[] words = line.split(" ");
        // 遍历输出拆分后的每个单词
//        for (String word : words) {
//            System.out.println(word);
//        }
        String word="";
//        处理三次
        for (int i=0 ;i<3;i++){
            word+=words[i]+" ";
        }
        return word;
        // 处理每一行的代码
//        return words[words.length-1];

    }

    /**
     * 取每行的最后一个
     * @param line
     * @return
     */
    private static String processLineTest1(String line) {
        String lastThree = line.substring(line.length() - 8);

        // 处理每一行的代码
        return lastThree;

    }

    /**
     * 根据空格拆分
     * @param line
     * @return
     */
    private static String processLineLast(String line) {

        // 根据空格拆分
        String[] words = line.split(" ");

        return words[words.length-1];

    }


}
