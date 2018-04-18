package com.brovada.document;

import java.util.HashMap;

public class Actions extends HashMap<String, Actions.ActionService> {

    // e.g.    "BIND" --> 'bindService'

    public Actions addServiceAction(String action, String service) {
        put(action, new ActionService(service,"local"));
        return this;
    }

    // e.g.    "BIND" --> 'http://foo.com/bind'

    public Actions addRemoteAction(String action, String service) {
        put(action, new ActionService(service,"remote"));
        return this;
    }

    // e.g.    "BIND" --> 'bind'.   will use service discovery by name.

    public Actions addMicroServiceAction(String action, String service) {
        put(action, new ActionService(service, "micro"));
        return this;
    }

    
    static class ActionService {
        private String name;
        private String type;

        public ActionService(String name, String type) {
            this.name = name;
        }

        String getName() { return name; }
    }


}
