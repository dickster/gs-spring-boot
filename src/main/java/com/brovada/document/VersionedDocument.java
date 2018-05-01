package com.brovada.document;

public interface VersionedDocument {

    public Version getVersion();
    // add auditing. user,  modified.
    public String getId();
    
    // hmmm...policies are very well suited for mongo.
    // but versioned documents and references are better in RDBMS

}
