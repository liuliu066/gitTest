package com.test.stringInfo;

import com.test.test.Student;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lwh
 * @date 2021/10/14 16:47
 */
public class StringTest {


    public static void main(String[] args) {
//        List list=null;
//
//        boolean aa = list.add("aa");

//


    }

    /**
     * char基本数据类型转化为引用数据类型String
     */

    @Test
    public void test01() {
        String aa = "";
        char bb = '1';
        aa = aa + String.valueOf(bb);
        System.out.println(aa);
    }

    /**
     * String str="hello world"和String str=new String("hello world")的区别
     */
    @Test
    public void stringTest(){
        String str1 = "hello world";
        String str2 = new String("hello world");
        String str3 = "hello world";
        String str4 = new String("hello world");

        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str2==str4);
    }

    /**
     * StringBuffer: 线程安全的可变字符串
     * 我们如果对字符串进行拼接操作，每次拼接都会构成一个新的String对象，既耗时，又浪费空间
     * StringBuffer可以解决这个问题。
     * StringBuffer和String的区别:前者长度和内容可变，后者不可变
     */
    @Test
    public void stringBufferTest(){
        StringBuffer sb=new StringBuffer();
        System.out.println("capacity():返回当前容量 理论值");
        System.out.println("length():返回长度(字符数) 实际值");
        System.out.println("sb:"+sb);
        System.out.println("sb.capacity():"+sb.capacity());
        System.out.println("sb.length():"+sb.length());
        System.out.println("--------------------------------");
        StringBuffer sb2=new StringBuffer(50);
        System.out.println("sb2:"+sb2);
        System.out.println("sb2.capacity():"+sb2.capacity());
        System.out.println("sb2.length():"+sb2.length());
        System.out.println("--------------------------------");
        StringBuffer sb3=new StringBuffer("hello");
        System.out.println("sb3:"+sb3);
        System.out.println("sb3.capacity():"+sb3.capacity());
        System.out.println("sb3.length():"+sb3.length());
    }
    /**
     * StringBuffer的添加功能：
     *  public StringBuffer append(String str)
     *  可以把任意类型数据添加到字符串缓冲区里面，并返回字符串缓冲区本身
     *  public StringBuffer insert(int offset,String str)
     *  在指定位置把任意类型的数据插入到字符串缓冲区里面，并返回字符串缓冲区本身
     */

    @Test
    public void stringBufferAddTest(){
        StringBuffer sb=new StringBuffer();
        sb.append("hello");
        sb.append(1);
        sb.append(1.2);
        sb.append(true);
        System.out.println(sb);
        System.out.println("-------------------------");
        sb.append("hello").append(1).append(1.2).append(true);
        System.out.println(sb);
        System.out.println("-------------------------");
        sb.insert(5, 22222);
        System.out.println(sb);
    }

    /**
     * StringBuffer的删除功能：
     *
     * public StringBuffer deleteCharAt(int index)
     * 删除指定位置字符，并返回本身
     * public StringBuffer delete(int start,int end)
     * 删除从指定位置开始，并从指定位置结束字符，并返回本身
     * 注：包左不包右
     */
    @Test
    public void stringBufferDeleteTest(){
        StringBuffer sb= new StringBuffer();
        sb.append("hello").append("world").append("java");
        System.out.println(sb);
        sb.delete(0, 5);
        System.out.println(sb);
        sb.deleteCharAt(0);
        System.out.println(sb);
        sb.delete(0, sb.length());
        System.out.println("sb"+sb);

    }

    /**
     * StringBuffer的截取功能：注意返回值类型不是StringBuffer
     *
     * public String substring(int start)
     * public String substring(int start,int end)
     */
    @Test
    public void stringBufferCutTest(){
        StringBuffer sb =new StringBuffer();
        sb.append("hello").append("world").append("java");
        System.out.println(sb);
        String s=sb.substring(5);
        System.out.println(s);
        String ss=sb.substring(5, 10);
        System.out.println(ss);
    }
    /**
     * StringBuffer的替换功能：
     * public StringBuffer replace(int start,int end,String str),从start到end用str替换
     */
    @Test
    public void stringBufferReplaceTest(){
        StringBuffer sb=new StringBuffer();
        sb.append("hello").append("world").append("java");
        sb.replace( 0, 5, "啦啦啦");
        System.out.println(sb);
    }

    @Test
    public void testSan(){
        int a=2;
        System.out.println(a==1?0:1);
    }


    /**
     * StringBuffer的反转功能：
     * public StringBuffer reverse()
     */
    @Test
    public void stringBufferReverseTest(){
        StringBuffer sb=new StringBuffer();
        sb.append("hello");
        sb.reverse();
        System.out.println(sb);
    }

    @Test
    public void  test11111111(){

        String aa= "100023727";
        String cc= "100020027";
        String ss = "19999000300980137";
        System.out.println(aa.substring(5,9));
        String substring = cc.substring(5, 9);
        String qq = ss.substring(9, 13);
        System.out.println(qq);
        Long bb= Long.valueOf(substring);
        System.out.println(bb);
    }


    @Test
    public void  test11221(){
//        System.out.println(checkMobilePhone("09949140411"));

        Long aa= 11111l;
        Long bb= 1111l;
        Long cc= 111l;
        Long dd= 111l;
        long ee = 11111l;
//        System.out.println(aa != bb);
        System.out.println(aa ==bb);
        System.out.println(cc ==dd);
        System.out.println(aa ==ee);
    }

    @Test
    public void  tesr11(){
        checkMobilePhone("19949140411");
    }

    private String checkMobilePhone(String mobilePhone) {
        if (StringUtils.isEmpty(mobilePhone)) {
            return "手机号不能为空！";
        }
//        String regex = "^(0|86|17951)?(13[0-9]|15[012356789]|17[3678]|18[0-9]|14[57])[0-9]{8}$";
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9])|(16[6]))\\d{8}$";
        if (mobilePhone.length() != 11) {
            return "手机号应为11位数";
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(mobilePhone);
            boolean isMatch = m.matches();
            if (isMatch) {
                return "";
            } else {
                return "手机号" + mobilePhone + "错误格式！";
            }
        }

    }



}
