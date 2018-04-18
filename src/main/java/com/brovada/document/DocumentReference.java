package com.brovada.document;

import javax.annotation.Nullable;

public class DocumentReference<T> {
    String id;
    @Nullable Version version;

    public DocumentReference(String id) {
        this.id=id;
    }
}
