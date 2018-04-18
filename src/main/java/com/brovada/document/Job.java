package com.brovada.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Job implements VersionedDocument {

    @Id
    public String id;

    // an action button can call radar.  will save new version of job.
    // every action will do this unless specified?   actionButtonConfig('SUBMIT', saveNewVersion:true}

    private Version version = new Version(1);
    private DocumentReference<JobConfig> configRef; // a reference. not included.
    private JobState state = new JobState();
    private JobData data = new JobData();


    public Job() {

    }
    
    @Override
    public Version getVersion() {
        return version;
    }


    public void setVersion(Version version) {
        this.version = version;
    }

    public DocumentReference<JobConfig> getConfigRef() {
        return configRef;
    }

    public void setConfigRef(DocumentReference<JobConfig> configRef) {
        this.configRef = configRef;
    }

    public JobState getState() {
        return state;
    }

    public void setState(JobState state) {
        this.state = state;
    }

    public JobData getData() {
        return data;
    }

    public void setData(JobData data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "configRef=" + configRef +
                ", data=" + data +
                ", id='" + id + '\'' +
                ", state=" + state +
                ", version=" + version +
                '}';
    }

    public Job withJobConfig(JobConfig jobConfig) {
        // TODO : add version reference here.
        setConfigRef(new DocumentReference<JobConfig>(jobConfig.getId()));
        return this;
    }
}
