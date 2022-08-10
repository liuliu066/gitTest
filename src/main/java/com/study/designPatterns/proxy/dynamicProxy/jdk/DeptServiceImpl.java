package com.study.designPatterns.proxy.dynamicProxy.jdk;

import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 15:44
 */
public class DeptServiceImpl implements DeptService{

    /**
     * 模拟业务逻辑操作
     * @param var1
     * @return
     */

    @Override
    public boolean save(Map var1) {
        System.out.println("模拟部门添加。。。");
        return false;
    }

    @Override
    public boolean remove(Map var1) {
        System.out.println("模拟部门删除。。。");
        return false;
    }

    @Override
    public boolean update(Map var1) {
        System.out.println("模拟部门更细。。。");
        return false;
    }
}
