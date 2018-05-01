package com.brovada.document;

public final class JobBuilder {
    private DocumentReference<JobConfig> configRef; // a reference. not included.
    private JobState state;
    private JobData data;
    private Version version;

    private JobBuilder() {
    }

    public static JobBuilder aJob() {
        return new JobBuilder();
    }

    public JobBuilder withConfigRef(DocumentReference<JobConfig> configRef) {
        this.configRef = configRef;
        return this;
    }

    public JobBuilder withState(JobState state) {
        this.state = state;
        return this;
    }

    public JobBuilder withData(JobData data) {
        this.data = data;
        return this;
    }

    public JobBuilder withVersion(Version version) {
        this.version = version;
        return this;
    }

    public Job build() {
        Job job = new Job();
        job.setConfigRef(configRef);
        job.setState(state);
        return job;
    }
}
