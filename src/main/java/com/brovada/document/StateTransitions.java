package com.brovada.document;

import java.util.HashMap;

public class StateTransitions extends HashMap<String, String> {

    public StateTransitions() {

    }

    public StateTransitions withTransition(String action, String state) {
         put(action, state);
         return this;
    }
}
