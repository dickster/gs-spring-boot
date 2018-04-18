package com.brovada.repository;

import com.brovada.document.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JobRepository extends MongoRepository<Job, String> {

    public Optional<Job> findById(String id);
}
