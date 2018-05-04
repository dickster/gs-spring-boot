package com.brovada.document;

import javax.annotation.Nullable;
import java.util.List;


// e.g. /validate   (internal)
//      www.fooBar.com/comments    (external)
//      tickets   (internal service discovery lookup id)


public class ActionService {
    // currently supports only rest.   TODO : add any required config for soap/thrift.
    private String name;
    @Nullable private String type;
    @Nullable private String host;
    @Nullable private ServiceHttpHeaders headers;
    @Nullable private Mapping outgoing;
    @Nullable private Mapping incoming;
    @Nullable private List<String> params;   // list of query values to pass.    e.g. foo.bar.country   (you must know the existing schema of form).

    public ActionService(String name, String type) {
        this.name = name;
    }

    String getName() { return name; }
}
