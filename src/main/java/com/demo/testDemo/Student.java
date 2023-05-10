package com.demo.testDemo;

import lombok.Data;

/**
 * @author lwh
 * @description:
 * @date 2023/4/24 12:56
 */
@Data
public class Student {

    private Long id;

    private String name;

    private Double score;

    public Student() {}

    public Student(Long id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
