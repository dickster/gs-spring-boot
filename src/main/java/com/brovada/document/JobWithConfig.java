package com.brovada.document;

// payload used by client.
// it has everything it needs here.  all references are resolved and merged in.
// Note that this isn't saved per se.   Only the job can be updated (a new version is stored).
//   and within the job, only the state & data can change.  the reference to config is immutable.
public class JobWithConfig {

    private Job job;
    private JobConfig config;

    public JobWithConfig(Job job, JobConfig config) {
        this.job = job;
        this.config = config;

    }
}
