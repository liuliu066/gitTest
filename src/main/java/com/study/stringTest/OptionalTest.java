package com.study.stringTest;

import org.junit.Test;

import java.util.*;

/**
 * @author lwh
 * @date 2022/7/28 9:33
 */
public class OptionalTest {

    @Test
    public void test001(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.toString());
        System.out.println(empty.isPresent());
    }
    @Test
    public void test002(){
        // 创建 map 对象
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name1", "mydlq");
        userMap.put("name2", null);

        // 传入 Map 对象参数，获取一个 Optional 对象，获取 name1 属性
        Optional<String> optional1 = Optional.of(userMap).map(value -> value.get("name1"));

        // 传入 Map 对象参数，获取一个 Optional 对象，获取 name2 属性
        Optional<String> optional2 = Optional.of(userMap).map(value -> value.get("name2"));

        // 获取 Optional 的值
        System.out.println("获取的 name1 的值：" + optional1.orElse("默认值"));
        System.out.println("获取的 name2 的值：" + optional2.orElse("默认值"));

    }


    /**
     * 测试optional常用方法案例
     */
    @Test
    public void test003() {
        // 创建一个测试的用户集合
        List<User> userList = new ArrayList<>();

        // 创建几个测试用户
        User user1 = new User("abc");
        User user2 = new User("efg");
        User user3 = null;

        // 将用户加入集合
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // 创建用于存储姓名的集合
        List<String> nameList = new ArrayList();
        // 循环用户列表获取用户信息，值获取不为空且用户以 a 开头的姓名，
        // 如果不符合条件就设置默认值，最后将符合条件的用户姓名加入姓名集合
        for (User user : userList) {
            nameList.add(Optional.ofNullable(user).map(User::getName).filter(value -> value.startsWith("a")).orElse("未填写"));
        }

        // 输出名字集合中的值
        System.out.println("通过 Optional 过滤的集合输出：");
        nameList.stream().forEach(System.out::println);
    }


    /**
     *  map经典判空之嵌套if
     * 判断map不为空，map中的key-value不为null且不为空白字符串，常规玩法要么是一组嵌套if，要是是一个tay-catch
     */
    @Test
    public void test005(){
        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        System.out.println(test4());
    }

    public static String test1() {
        //假装外部传入不可控map一个，比如sevlet接受前端传参
        Map pm = new HashMap();
        pm.put("key1", "value1");


        Optional<Map> mapOptional = Optional.ofNullable(pm);

        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //一大堆业务处理...
                    return Optional.ofNullable("test1成功执行");
                }).orElse("test1停车了");
    }

    public static String test2() {
        //假装外部传入不可控map一个，比如sevlet接受前端传参
        Map pm = new HashMap();
        pm.put("key1", "");
        Optional<Map> mapOptional = Optional.ofNullable(pm);
        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //一大堆业务处理...
                    return Optional.ofNullable("test2成功执行");
                }).orElse("test2停车了");
    }


    public static String test3() {
        //假装外部传入不可控map一个，比如sevlet接受前端传参
        Map pm = new HashMap();
        pm.put("key1", null);
        Optional<Map> mapOptional = Optional.ofNullable(pm);
        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //一大堆业务处理...
                    return Optional.ofNullable("test3成功执行");
                }).orElse("test3停车了");
    }
    public static String test4() {
        //假装外部传入map一个，不传指定key
        Map pm = new HashMap();

        Optional<Map> mapOptional = Optional.ofNullable(pm);
        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //开始啪啪业务逻辑 发短信啊crud啊...
                    return Optional.ofNullable("test4成功执行");
                }).orElse("test4停车了");
    }








}
