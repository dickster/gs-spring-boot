package com.brovada;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}




// worfklow called by browser.
// POST ../job  {job including data)   updates it and returns new state.

// reads job.  figures out current state, delegates to service mapped to ??
// (microservices = URL or via service discovery.  monolithic = bean Name.
// all job services take data, job (incl. state info), config info (validations, forms, bizLogic, translations)
//


//../job   {POST:jobId, jobState, data, eventName  [default=Submit?]}
// workflow service :
//   ..read JobConfig.
//   merge data with existing data.
//   based on current state, lookup proper service to call.  (default = validate)
//   call service
//   results can update data => current State & job data.
//   persist the job and return it.
// service returns payload { data: { state: newState, model:stuff }, result: {code:"E2123", msg:"your {x} is blah", cause:"validation78"}}
//
//   job must be created and audited when first


//PUT ../job?jobConfigId=77    or PUT ../job?jobName="auto"&ver=2.1
// creates JOB - which has configId & empty data.   (default data = what?)  config has template?
// has default currentState or null?

// GET ../job&jobId    like "start".

// POST ../job&jobId   trigger event   (update job).      need to post (or call service internally)  @Inject jobService.   jobService.event(jobIncludingData&Config&State, trigger)
//  take trigger and look up it's associated Service.   call it (must implement JobSErvice { event(job, eventName);  return { job  }

// Job = {
//    jobConfigId: <resolveThisAndMerge>
//       { stateTable: {  a: { 200:"b", 400:"c", '[201,202,403]':"e", etc... }
//        events = <optional> if you use a code like "anyError" --> '[400..499]'
//        stateRouting = "a" ==> componentName||url||serviceName?
//        by default, state is configurableForm name. (or non-configurable form component name).  Version optionally included. 
//
//    client responsible for routing.   what to do after result comes back and in new state.  headless has it's own...how does it trigger a new event.
//    if no flow...just calling a bunch of services then bundle that up into the initial service call.
// jobConfig will handle event(job, trigger)  -->  each trigger has { servicename||url  or [serviceName||url]
//    a[NEXT]={   [a,b,c]    passes job to all of them.   each updates job optionally }
//    job = a.trigger(job, NEXT);
//    job = b.trigger(job, NEXT);
//    job = c.trigger(job, NEXT);
//    return job;
//
//    spring lookup bean || rest template.
//    formConfig = { actionButton: 'NEXT'  (or 'ADD_DRIVER' or whatever....?).   default = VALIDATE }
//
//    validate(job, state);   // each state can have a validations filter defining which to include/exclude.
//    some validations are marked serverSide only.  (@Inject validateForState(job, job.currentState)
//
//   each job is immutable.  a new version is stored each time with audit trail.  increase patch version each time.
//   new job = DEREK.    1.0.0   1.0.1.
//   each time move backup copies to another collection and rewrite 'TRUNK'
//
//
