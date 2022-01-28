package com.example.demo.test;

import com.cnhtc.hdf.wf.common.web.util.IntekeyUtils;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * @author lwh
 * @date 2022/1/25 10:38
 */
public class FileUtils {
    @Test
    public void test() throws IOException {
        File file1 = new File("D:\\data\\gradeInfo.xlsx");
        String intekeyUrl = " http://10.2.158.196/api/intekey/file";

        //    fileת��ΪmultipartFile ��Ҫ����maven���� spring-test
        FileInputStream fileInputStream = new FileInputStream(file1);
        MultipartFile file = new MockMultipartFile(file1.getName(), file1.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        String appCode = "hr";
        String secretKey = "hr1234.";
        //���ļ����н���
        InputStream inputStream = IntekeyUtils.DecryptFile(intekeyUrl, appCode, secretKey, file);

        //  ��ȡ�ļ���׺
        //��ȡ�ļ���ԭʼ����
        String originalFilename = file.getOriginalFilename();
        //��ȡ���һ��.��λ��
        int lastIndexOf = originalFilename.lastIndexOf(".");
        //��ȡ�ļ��ĺ�׺�� .pptx
        String suffix = originalFilename.substring(lastIndexOf);
        //�����ļ�·��
        String destination = "D:\\data\\111" + suffix;
        int index;
        byte[] bytes = new byte[1024];
//        FileOutputStream downloadFile = new FileOutputStream("D:\\data\\test.pptx");
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = inputStream.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        downloadFile.close();
        inputStream.close();

    }


}


