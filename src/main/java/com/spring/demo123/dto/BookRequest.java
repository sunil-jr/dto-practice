package com.spring.demo123.dto;

import lombok.Data;

@Data
public class BookRequest {

    private String name;

    private String author;

    private Double price;
}
