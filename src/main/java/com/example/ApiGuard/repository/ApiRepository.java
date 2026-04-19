package com.example.ApiGuard.repository;


import com.example.ApiGuard.entity.ApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ApiRepository extends JpaRepository<ApiEntity, UUID> {
}