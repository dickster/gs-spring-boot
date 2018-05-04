package com.brovada.document;

import com.brovada.document.config.Translatable;
import com.google.common.collect.Maps;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
public class Choices implements VersionedDocument {


    // all static data like countries, cities, vehicleModels, wiringTypes etc.. will exist in this collection.
    // 
    private String name;   // @Unique   basically the collection name.   e.g. vehicleManufacturers.
    private String id;
    private VersionFoo version;
    private @Translatable
    Map<String, String> map=Maps.newHashMap();
    // TODO : add "other" values   like hint, msg,

    public Choices withChoice(String key, String value) {
        map.put(key, value);
        return this;
    }

    @Override
    public VersionFoo getVersion() {
        return version;
    }

    @Override
    public String getId() {
        return id;
    }
}
