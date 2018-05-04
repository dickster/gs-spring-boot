package com.brovada.document;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;

public class StateTransitions extends HashMap<Event, String> {

    private @Nullable String catchAll;

    public StateTransitions() {
    }

    public StateTransitions withTransition(Event event, String state) {
         put(event, state);
         return this;
    }

    public StateTransitions withTransition(int code, String state) {
         put(new Event(code), state);
         return this;
    }

    public StateTransitions withTransition(int start, int end, String state) {
        put(new Event(new EventCode.EventCodeRange(start, end)), state);
        return this;
    }

    public StateTransitions withCatchAllTransition(String state) {
       this.catchAll = state;
        return this;
    }

    public String getStateForEvent(Event event) {
        return super.get(event);
    }

    public Collection<String> getAllPossibleStates() {
        return values();
    }

    @Nullable
    public String getCatchAll() {
        return catchAll;
    }
}
