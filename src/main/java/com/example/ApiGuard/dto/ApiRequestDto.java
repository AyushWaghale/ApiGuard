package com.example.ApiGuard.dto;


import lombok.Data;

@Data
public class ApiRequestDto {
    private String name;
    private String url;
    private String method;
    private int intervalSeconds;
    private int timeout;
}