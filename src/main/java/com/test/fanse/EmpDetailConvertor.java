package com.test.fanse;

/**
 * @author lwh
 * @date 2022/1/7 10:35
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EmpDetailConvertor {
    /**
     * 将草稿表对象转换成两个明细表对象，草稿表的属性存在Bef,Aft前后值
     * @param hrEmpDraftDetail 草稿表对象，
     * @param targetClass 员工信息明细表class对象，
     */
    public Map<String, Object> convert(Object hrEmpDraftDetail, Class targetClass) {
        Map<String, Object> result = new HashMap();
        if (hrEmpDraftDetail == null) {
            return result;
        }

        long startTime = System.currentTimeMillis();

        // 创建明细表对象
        Object newObjectBef = this.createNewObject(targetClass);
        Object newObjectAft = this.createNewObject(targetClass);

        // 复制草稿表相同字段到两个明细表对象中
        BeanUtils.copyProperties(hrEmpDraftDetail, newObjectBef);
        BeanUtils.copyProperties(hrEmpDraftDetail, newObjectAft);

        // 处理草稿表的属性存在Bef,Aft的字段，将Bef复制到newObjectBef，Aft复制到newObjectAft中
        Class<?> draftClass = hrEmpDraftDetail.getClass();
        Field[] fields = draftClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String originFieldName = fieldName.replace("Bef", "");
            originFieldName = originFieldName.replace("Aft", "");
            if (fieldName.contains("Bef")) {
                this.setFieldValue(newObjectBef, this.getField(newObjectBef, originFieldName), this.getFieldValue(hrEmpDraftDetail, field));
            } else if (fieldName.contains("Aft")) {
                this.setFieldValue(newObjectAft, this.getField(newObjectAft, originFieldName), this.getFieldValue(hrEmpDraftDetail, field));
            }
        }

        // 将两个对象存到Map中返回
        result.put("bef", newObjectBef);
        result.put("aft", newObjectAft);

        long endTime = System.currentTimeMillis();
        log.info("耗时：{} ms", endTime - startTime);
        return result;
    }


    private Object createNewObject(Class<?> tClass) {
        Object newObject = null;
        try {
            Constructor constructor = tClass.getDeclaredConstructor();
            newObject = constructor.newInstance();
        } catch (Exception e) {
            log.error("复制对象失败", e);
        }
        return newObject;
    }

    private void setFieldValue(Object obj, Field field, Object value) {
        if (field == null) {
            return;
        }

        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            log.error("调用异常, {}", e);
        }
    }
    private Object getFieldValue(Object obj, Field field) {
        if (field == null) {
            return null;
        }

        try {
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            log.error("调用异常, {}", e);
        }
        return null;
    }

    private Field getField(Object obj, String fieldName) {
        try {
            return obj.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            log.error("无此字段", e);
        }
        return null;
    }
}
