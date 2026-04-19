package com.example.ApiGuard.scheduler;

import com.example.ApiGuard.entity.ApiEntity;
import com.example.ApiGuard.repository.ApiRepository;
import com.example.ApiGuard.scheduler.ApiMonitoringScheduler;
import com.example.ApiGuard.repository.MetricRepository;
import com.example.ApiGuard.entity.MetricEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;


import java.util.List;

@Component
public class ApiMonitoringScheduler {

    @Autowired
    private ApiRepository repo;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private MetricRepository metricRepo;

    @Scheduled(fixedRate = 30000)
    public void monitorApis() {

        List<ApiEntity> apis = repo.findAll();

        for (ApiEntity api : apis) {
            try {
                System.out.println("Checking API: " + api.getUrl());

                long start = System.currentTimeMillis();

                ResponseEntity<String> response =
                        restTemplate.getForEntity(api.getUrl(), String.class);

                long end = System.currentTimeMillis();
                long responseTime = end - start;

                MetricEntity metric = new MetricEntity();
                metric.setApi(api);
                metric.setResponseTime(responseTime);
                metric.setStatusCode(response.getStatusCode().value());
                metric.setSuccess(response.getStatusCode().is2xxSuccessful());

                metricRepo.save(metric); // ⭐ IMPORTANT

            } catch (Exception e) {
                System.out.println("API FAILED: " + api.getUrl());

                MetricEntity metric = new MetricEntity();
                metric.setApi(api);
                metric.setSuccess(false);

                metricRepo.save(metric); // ⭐ SAVE FAILURE ALSO
            }
        }
    }
}