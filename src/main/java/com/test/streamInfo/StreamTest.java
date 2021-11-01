package com.test.streamInfo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lwh
 * @date 2021/10/21 9:11
 */
public class StreamTest {

    @Test
    public void test6() {
        Stream stream = Stream.of("abc", "def");

        String[] array = (String[]) stream.toArray(String[]::new);
        System.out.println(array.length);
        List<String> list = (List<String>) Stream.of("1", "2", "3").collect(Collectors.toList());
        String str = Stream.of("abc", "mn")
                .collect(Collectors.joining())
                .toString();
        System.out.println(array);
        System.out.println(list);
        System.out.println(str);
    }

    /**
     * User对象集合中,取出User的电话号码
     **/
//    class StreamMap{
//        public List<String> getUserPhone(List<User> users){
//            //取出User中的phone集合,返回
//            return users.stream().map(User::getPhone).collect(Collectors.toList());
//        }
//    }




}
