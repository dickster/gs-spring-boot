package com.brovada.service;

import com.brovada.document.JobConfig;
import com.brovada.document.JobData;
import com.brovada.document.JobWithConfig;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class JobDataService {


    public JobData create() {
        return new JobData();
    }

    
}
