package com.example.kafkaexample.kafkaexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {

    private String name;
    private Integer age;
}
