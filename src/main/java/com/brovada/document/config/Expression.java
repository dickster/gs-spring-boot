package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Expression {

    // need to turn meta data into .js. 
    private String str;
    private ErrorMessage msg;

    public String getJavascriptStr() {
        // TODO : turn str into javascript.  assume str is just meta data.
        // could be something like ">10" and the javascript needs to be say, "value>10"
        return str;
    }




    // e.g. this > 10
    // square(this) < 100
    // foo.bar.x > someFn(this)
    // and
    // Or
    // size(list)==2
    // policy.insured.name.first==this
    // length(this) > 6
    // this in countries
    // this in countries and policy.location.province=QC
    // this + policy.coverage@CoverageName.deductible == 100




}

