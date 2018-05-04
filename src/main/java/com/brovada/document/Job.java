package com.brovada.document;

import com.google.common.collect.Lists;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Job {  // enable auditing for this.

    @Id
    public String id;

    @Version
    private long version;
    private String lob;  // change this enum.   add any other siginificant keys/meta-data?

    // an action button can call radar.  will save new version of job.
    // every action will do this unless specified?   actionButtonConfig('SUBMIT', saveNewVersion:true}
    
    @DBRef   // lazy=false.   do I ever need this to be true?   how do I specify the version of this?
    //  should I extend DBRef or add another annotation?
    private JobConfig config; // a reference. not included.    this could be null if you just want to create policy data.  maybe storing LOB is enough.
    // NESTED -  not a reference.
    private JobData data;
    private JobState state = JobState.INITIAL;  // don't need versions of states.


    public Job() {
    }

    public JobConfig getConfig() {
        return config;
    }

    public void setConfig(JobConfig config) {
        this.config = config;
    }

    public JobState getState() {
        return state;
    }

    void setState(JobState state) {
        // assert state is in state table.  this should only be done
        this.state = state;
    }

    public List<String> getValidStates() {
        List<String> result = Lists.newArrayList();
        for (String state:getConfig().getStateTable().keySet()) {
            result.add(state);
        }
        return result;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "config=" + config +
                ", data=" + data +
                ", id='" + id + '\'' +
                ", state=" + state +
                '}';
    }


    public void setState(String state) {
        this.state = new JobState(state);
    }


}
