package com.test.enum1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lwh
 * @date 2021/10/13 15:18
 */
public class EnumTest {

    public static void main(String[] args) {
        EnumTest enumTest= new EnumTest();
        List<String> languageInfo = enumTest.getLanguageInfo(2, 3);
        System.out.println(languageInfo);
    }
    public List<String> getLanguageInfo(int languageType, int languageGrade){
        List<String> list = new ArrayList<>();
        String languageTypeMsg = EmpInfoLanguageType.getMsgByLanguageTypeCode(languageType);
        String languageGradeMsg = EmpInfoLanguageGrade.getMsgByLanguageGradeCode(languageGrade);
        if (null==languageTypeMsg){
            return null;
        }
        list.add(languageTypeMsg);
        list.add(languageGradeMsg);
        return list;
    }
}
