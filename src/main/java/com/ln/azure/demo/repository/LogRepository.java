package com.ln.azure.demo.repository;

import com.ln.azure.demo.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Time> {
}
