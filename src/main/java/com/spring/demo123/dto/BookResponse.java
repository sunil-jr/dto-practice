package com.spring.demo123.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookResponse {

    private Long id;

    private String name;

    private String author;

    private Double price;
}
