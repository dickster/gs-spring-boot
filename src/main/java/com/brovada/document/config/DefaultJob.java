package com.brovada.document.config;

import com.brovada.document.Job;

public class DefaultJob extends Job {

    public DefaultJob() {
        super();
        setConfig(new DefaultJobConfig());
    }
}
