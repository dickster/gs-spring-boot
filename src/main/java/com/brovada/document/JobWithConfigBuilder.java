package com.brovada.document;

public final class JobWithConfigBuilder {
    private Job job;
    private JobConfig config;

    private JobWithConfigBuilder() {
    }

    public static JobWithConfigBuilder aJobWithConfig() {
        return new JobWithConfigBuilder();
    }

    public JobWithConfigBuilder withJob(Job job) {
        this.job = job;
        return this;
    }

    public JobWithConfigBuilder withConfig(JobConfig config) {
        this.config = config;
        return this;
    }

    public JobWithConfig build() {
        return new JobWithConfig(job, config);
    }
}
