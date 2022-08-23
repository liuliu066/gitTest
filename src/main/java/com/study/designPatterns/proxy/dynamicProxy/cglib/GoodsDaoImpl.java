package com.study.designPatterns.proxy.dynamicProxy.cglib;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 17:04
 */
public class GoodsDaoImpl {


    /**
     * 商品添加
     * @param map
     * @return
     */
    public int add(Map map){
        System.out.println("模拟添加。。。");
        return -1;
    }

    /**
     * 商品删除
     * @param map
     * @return
     *
     * 如果写final的话 无法代理到此方法，因为是重写的，final是不行的
     */
    public final int delete(Map map){
        System.out.println("模拟删除。。。");
        return -1;
    }

    /**
     * 商品修改
     * @param map
     * @return
     */
    public int update(Map map){
        System.out.println("模拟修改。。。");
        return -1;
    }


}
