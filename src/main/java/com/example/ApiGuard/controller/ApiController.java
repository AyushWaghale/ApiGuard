package com.example.ApiGuard.controller;


import com.example.ApiGuard.entity.ApiEntity;
import com.example.ApiGuard.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ApiGuard.dto.ApiRequestDto;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/apis")
public class ApiController {

    @Autowired
    private ApiService service;

    @PostMapping
    public ApiEntity create(@RequestBody ApiRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ApiEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ApiEntity getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}