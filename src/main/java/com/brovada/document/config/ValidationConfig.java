package com.brovada.document.config;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.List;

public class ValidationConfig<T> {

    // hook into springs validation framework?

    private String bind;
    private List<Expression> expressions;

    // what type is the value?
    public void validate(Validation v) {
        // get value.  passing a value to javascript - will be turned into correct type?
        // value = getValue(bind, validation.context);    validation has policy object (or whatever variables are needed).
        // loop over expressions.
        // result = wtw.validations.eval(value, expression);
        // if !result validation.error('blah blah blah', expression, value);

        // allow for custom one-off methods   (by convention?  if wtw.validations.<fieldName> exists, then call it)
    }


    // on client side, you have a wtw.validations function object.
    // you attach the validation expression & object to Vue component.
    //  how do i load this into VUE????


    // add custom methods how?? can I prototype the .js object?   or load in external files?

    // .:   have a single validation .js file that has all the built in functions.
    // you can add to this file (which defines wtw.validations)

    // .js     doIt(value, expression) {    // expr=='value>10';
    //             eval(expression);

// call with proper context.
//    var result = function(str){
//        return eval(str);
//    }.call(context,'value>10');

    // var wtw = wtw ? wtw : {};
    // wtw.validations = function() {
    //      validate(value, context);
    //      return {
    //         email: email,
    //         validate: validate
    //      }
    // }


    public Object getValue(Object context) {
        BeanWrapper x = new BeanWrapperImpl(context);
        Object value = x.getPropertyValue(bind);
        return value;
    }

}
