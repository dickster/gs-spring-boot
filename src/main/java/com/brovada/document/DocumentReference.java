package com.brovada.document;

import javax.annotation.Nullable;


// TODO : use @DBREF instead.
public class DocumentReference<T> {
    String id;
    @Nullable
    VersionFoo version;

    public DocumentReference(String id) {
        this.id=id;
    }

    public DocumentReference(VersionedDocument document) {
        this.id = document.getId();
        this.version = document.getVersion();
    }
}
