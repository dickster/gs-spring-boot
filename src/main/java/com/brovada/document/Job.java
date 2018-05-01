package com.brovada.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Job implements VersionedDocument {

    @Id
    public String id;

    private Version version;
    private String lob;  // change this enum.   add any other siginificant keys/meta-data?

    // an action button can call radar.  will save new version of job.
    // every action will do this unless specified?   actionButtonConfig('SUBMIT', saveNewVersion:true}

    // use DBRef instead of documentReference?    should this always be HEAD?  NO!
    private /**Immutable*/ DocumentReference<JobConfig> configRef; // a reference. not included.    this could be null if you just want to create policy data.  maybe storing LOB is enough.
    // NESTED -  not a reference.
    private JobData data;
    private JobState state = new JobState();  // don't need versions of states.

    private transient JobConfig jobConfig; /* hydrated only when sent to client?*/


    public Job() {

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
                '}';
    }

    public Job withJobConfig(JobConfig jobConfig) {
        setConfigRef(new DocumentReference<JobConfig>(jobConfig));
        return this;
    }

    @Override
    public Version getVersion() {
        return version;
    }
}
