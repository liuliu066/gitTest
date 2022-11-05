package com.test.dateTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author lwh
 * @description:
 * @date 2022/9/30 14:56
 */
@Slf4j
public class DateTest {


    @Test
    public void getBaby() {
        BabyEntity babyEntity = new BabyEntity();
        babyEntity.setBirthday("2022-09-01 00:00:00");
        babyEntity.setId(11L);
        babyEntity.setSex(1);
        log.info("babyEntity.createTime={}", babyEntity.getBirthday());
        log.info("babyEntity{}", babyEntity);
        BabyDto babyDto = new BabyDto();
        BeanUtils.copyProperties(babyEntity, babyDto);
        System.out.println(babyDto);
    }

    @Test
    public void  test001(){
        System.out.println(new Integer(1));
    }

}
