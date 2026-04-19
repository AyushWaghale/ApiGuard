package com.example.ApiGuard.service;

import com.example.ApiGuard.entity.ApiEntity;
import com.example.ApiGuard.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private ApiRepository repo;

    public ApiEntity create(ApiEntity api) {
        return repo.save(api);
    }

    public List<ApiEntity> getAll() {
        return repo.findAll();
    }
}