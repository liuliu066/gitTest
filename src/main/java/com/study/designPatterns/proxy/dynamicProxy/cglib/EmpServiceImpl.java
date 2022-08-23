package com.study.designPatterns.proxy.dynamicProxy.cglib;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 17:02
 */
public class EmpServiceImpl {


    /**
     * 员工添加
     * @param map
     * @return
     */
    public int add(Map map){
        System.out.println("模拟添加。。。");
        return -1;
    }

    /**
     * 员工删除
     * @param map
     * @return
     */
    public int delete(Map map){
        System.out.println("模拟删除。。。");
        return -1;
    }

    /**
     * 员工修改
     * @param map
     * @return
     */
    public int update(Map map){
        System.out.println("模拟修改。。。");
        return -1;
    }


}
