package com.example.ApiGuard.controller;


import com.example.ApiGuard.entity.ApiEntity;
import com.example.ApiGuard.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ApiController {

    @Autowired
    private ApiService service;

    @PostMapping
    public ApiEntity create(@RequestBody ApiEntity api) {
        return service.create(api);
    }

    @GetMapping
    public List<ApiEntity> getAll() {
        return service.getAll();
    }
}