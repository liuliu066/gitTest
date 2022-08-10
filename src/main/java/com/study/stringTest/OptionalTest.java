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
        // ���� map ����
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name1", "mydlq");
        userMap.put("name2", null);

        // ���� Map �����������ȡһ�� Optional ���󣬻�ȡ name1 ����
        Optional<String> optional1 = Optional.of(userMap).map(value -> value.get("name1"));

        // ���� Map �����������ȡһ�� Optional ���󣬻�ȡ name2 ����
        Optional<String> optional2 = Optional.of(userMap).map(value -> value.get("name2"));

        // ��ȡ Optional ��ֵ
        System.out.println("��ȡ�� name1 ��ֵ��" + optional1.orElse("Ĭ��ֵ"));
        System.out.println("��ȡ�� name2 ��ֵ��" + optional2.orElse("Ĭ��ֵ"));

    }


    /**
     * ����optional���÷�������
     */
    @Test
    public void test003() {
        // ����һ�����Ե��û�����
        List<User> userList = new ArrayList<>();

        // �������������û�
        User user1 = new User("abc");
        User user2 = new User("efg");
        User user3 = null;

        // ���û����뼯��
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // �������ڴ洢�����ļ���
        List<String> nameList = new ArrayList();
        // ѭ���û��б��ȡ�û���Ϣ��ֵ��ȡ��Ϊ�����û��� a ��ͷ��������
        // �������������������Ĭ��ֵ����󽫷����������û�����������������
        for (User user : userList) {
            nameList.add(Optional.ofNullable(user).map(User::getName).filter(value -> value.startsWith("a")).orElse("δ��д"));
        }

        // ������ּ����е�ֵ
        System.out.println("ͨ�� Optional ���˵ļ��������");
        nameList.stream().forEach(System.out::println);
    }


    /**
     *  map�����п�֮Ƕ��if
     * �ж�map��Ϊ�գ�map�е�key-value��Ϊnull�Ҳ�Ϊ�հ��ַ����������淨Ҫô��һ��Ƕ��if��Ҫ����һ��tay-catch
     */
    @Test
    public void test005(){
        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        System.out.println(test4());
    }

    public static String test1() {
        //��װ�ⲿ���벻�ɿ�mapһ��������sevlet����ǰ�˴���
        Map pm = new HashMap();
        pm.put("key1", "value1");


        Optional<Map> mapOptional = Optional.ofNullable(pm);

        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //һ���ҵ����...
                    return Optional.ofNullable("test1�ɹ�ִ��");
                }).orElse("test1ͣ����");
    }

    public static String test2() {
        //��װ�ⲿ���벻�ɿ�mapһ��������sevlet����ǰ�˴���
        Map pm = new HashMap();
        pm.put("key1", "");
        Optional<Map> mapOptional = Optional.ofNullable(pm);
        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //һ���ҵ����...
                    return Optional.ofNullable("test2�ɹ�ִ��");
                }).orElse("test2ͣ����");
    }


    public static String test3() {
        //��װ�ⲿ���벻�ɿ�mapһ��������sevlet����ǰ�˴���
        Map pm = new HashMap();
        pm.put("key1", null);
        Optional<Map> mapOptional = Optional.ofNullable(pm);
        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //һ���ҵ����...
                    return Optional.ofNullable("test3�ɹ�ִ��");
                }).orElse("test3ͣ����");
    }
    public static String test4() {
        //��װ�ⲿ����mapһ��������ָ��key
        Map pm = new HashMap();

        Optional<Map> mapOptional = Optional.ofNullable(pm);
        return mapOptional.map(map -> map.get("key1"))
                .filter(value -> !"".equals(value))
                .flatMap(value -> {
                    //��ʼžžҵ���߼� �����Ű�crud��...
                    return Optional.ofNullable("test4�ɹ�ִ��");
                }).orElse("test4ͣ����");
    }








}
