package com.brovada.document;

import java.util.HashMap;

public class StateTransitions extends HashMap<Event, String> {

    public StateTransitions() {

    }

    public StateTransitions withTransition(Event event, String state) {
         put(event, state);
         return this;
    }
}
