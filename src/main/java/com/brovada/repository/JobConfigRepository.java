package com.brovada.repository;

import com.brovada.document.JobConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JobConfigRepository extends MongoRepository<JobConfig, String> {

    public Optional<JobConfig> findById(String id);
}
