package com.study.designPatterns.proxy.dynamicProxy.jdk;

import java.util.List;
import java.util.Map;

/**
 * @author lwh
 * @date 2022/8/10 15:42
 */
public interface DeptService {

    /**
     * ģ�����ݲ���
     */

    boolean save(Map var1);

    boolean remove(Map var1);


    boolean update(Map var1);

}
