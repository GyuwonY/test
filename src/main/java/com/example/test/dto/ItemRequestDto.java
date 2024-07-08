package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ItemRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;
}
