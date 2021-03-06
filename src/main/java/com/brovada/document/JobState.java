package com.brovada.document;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class JobState {
    public static final JobState INITIAL = new JobState("INITIAL");
    
    @Nonnull
    String name;
    @Nullable
    List<StateMsg> msgs = Lists.newArrayList();
    @Nullable
    Map<String,String> data = Maps.newHashMap();


    public JobState(@Nonnull String name) {
        this.name = name;
    }

    public JobState(@Nonnull String name, List<StateMsg> msgs) {
        this(name);
        this.msgs = msgs;
    }

    public JobState(@Nonnull String name, List<StateMsg> msgs, Map<String, String> data) {
        this(name, msgs);
        this.data = data;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    @Nullable
    public List<StateMsg> getMsgs() {
        return msgs;
    }

    public void setMsgs(@Nullable List<StateMsg> msgs) {
        this.msgs = msgs;
    }

    @Nullable
    public Map<String, String> getData() {
        return data;
    }

    public void setData(@Nullable Map<String, String> data) {
        this.data = data;
    }
}
