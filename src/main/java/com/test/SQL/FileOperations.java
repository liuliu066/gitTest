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
            // ��ȡ�ļ�
            File inputFile = new File("d:/data/S1_1xi0.9-Cloud.txt");
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // д���ļ�
            File outputFile = new File("d:/data/S1_1xi0.9-CloudLast.txt");
            FileWriter fileWriter = new FileWriter(outputFile);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // ��ÿһ�н��д���
                String processedLine = processLineLast(line);

                // ����������д�����ļ�
                fileWriter.write(processedLine);
                fileWriter.write("\n"); // д�س���

            }

            // �ر�����������
            bufferedReader.close();
            fileReader.close();
            fileWriter.close();
            System.out.println("over");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���ݿո���
     * @param line
     * @return
     */
    private static String processLine(String line) {

        // ���ݿո���
        String[] words = line.split(" ");
        // ���������ֺ��ÿ������
//        for (String word : words) {
//            System.out.println(word);
//        }
        String word="";
//        ��������
        for (int i=0 ;i<3;i++){
            word+=words[i]+" ";
        }
        return word;
        // ����ÿһ�еĴ���
//        return words[words.length-1];

    }

    /**
     * ȡÿ�е����һ��
     * @param line
     * @return
     */
    private static String processLineTest1(String line) {
        String lastThree = line.substring(line.length() - 8);

        // ����ÿһ�еĴ���
        return lastThree;

    }

    /**
     * ���ݿո���
     * @param line
     * @return
     */
    private static String processLineLast(String line) {

        // ���ݿո���
        String[] words = line.split(" ");

        return words[words.length-1];

    }


}
