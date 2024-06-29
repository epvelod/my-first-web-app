package com.ln.azure.demo.service;

import com.ln.azure.demo.entity.LogEntity;
import com.ln.azure.demo.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    LogRepository logRepository;

    public String hello() {
        Iterable<LogEntity> all = logRepository.findAll();

        return all.iterator().next().getLog();
    }
}
