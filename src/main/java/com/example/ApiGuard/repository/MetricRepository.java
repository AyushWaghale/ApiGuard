package com.example.ApiGuard.repository;

import com.example.ApiGuard.entity.ApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ApiGuard.entity.MetricEntity; // Ensure correct import
import org.springframework.stereotype.Repository; // Annotation import
import java.util.UUID;

@Repository
public interface MetricRepository extends JpaRepository<MetricEntity, UUID> {
}