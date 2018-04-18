package com.brovada.document;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class JobState {
    @Nonnull
    String currentState;
    @Nullable
    List<StateMsg> msgs = Lists.newArrayList();
    @Nullable
    Map<String,String> data = Maps.newHashMap();
}
