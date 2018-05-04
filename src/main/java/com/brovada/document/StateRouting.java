package com.brovada.document;

import java.util.HashMap;

public class StateRouting extends HashMap<String, StateRouting.Route> {


    // A -->  component name?  or url?
    // typically associated with a formConfigId and its' version

       public StateRouting() {

       }

       public StateRouting withRoute(String state, Route route) {
           // e.g. A --> formConfigId=33
           put(state, route);
           return this;
       }


       public static interface Route {
          // marker interface.
       }

       public static class FormConfigRoute implements Route {

           private String docId;
           private VersionFoo version;


       }

        public static class URLRoute implements Route {

           private String path;  // relative to base.
           private String base;


       }


}
