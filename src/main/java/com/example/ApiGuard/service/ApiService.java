package com.example.ApiGuard.service;

import java.util.UUID;
import com.example.ApiGuard.entity.ApiEntity;
import com.example.ApiGuard.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ApiGuard.dto.ApiRequestDto;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private ApiRepository repo;

    public ApiEntity create(ApiRequestDto dto) {
        ApiEntity api = new ApiEntity();
        api.setName(dto.getName());
        api.setUrl(dto.getUrl());
        api.setMethod(dto.getMethod());
        api.setIntervalSeconds(dto.getIntervalSeconds());
        api.setTimeout(dto.getTimeout());

        return repo.save(api);
    }

    public List<ApiEntity> getAll() {
        return repo.findAll();
    }

    public ApiEntity getById(UUID id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}