package com.demo.testDemo;

import com.demo.bo.InnoeIql;
import org.junit.Test;

/**
 * @author lwh
 * @description:
 * @date 2023/3/31 14:52
 */
public class InnoeTest {



    @Test
    public void test001(){
        InnoeIql innoeIql = new InnoeIql();

        innoeIql.setWhereClause("ssss");
        System.out.println(innoeIql);

        System.out.println(innoeIql.getAllTableSet());
        System.out.println(innoeIql.getAllTableSet().contains("xxxx"));






    }

}
