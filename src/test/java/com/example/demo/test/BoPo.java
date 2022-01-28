package com.example.demo.test;

import com.cnhtc.hdf.wf.common.web.util.IntekeyUtils;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author lwh
 * @date 2022/1/20 9:01
 */
public class BoPo {


    public static void main(String[] args) {
        Instant instant= null;
        String s = changeDate(instant);
        System.out.println(s);
    }



    @Test
    public void StringBuffer(){
        StringBuffer aaa = new StringBuffer();
        aaa.append("11111   ");
        aaa.append("aaaaaa");
        System.out.println(aaa.toString());

    }

    public static String changeDate(Instant instantFormDate){
        if(!StringUtils.isEmpty(instantFormDate)){
            Date date = Date.from(instantFormDate);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return  formatter.format(date);
        }
        return "";
    }
}
