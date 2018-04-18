package com.brovada.controller;

import com.brovada.document.Job;
import com.brovada.document.JobWithConfig;
import com.brovada.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//  PATCH /jobs/{id}    {action:'foo', policyData:{}}    if action is null, just patches.
//  POST /jobs     {jobConfigName:'auto', version:2.1.923}
//  GET  /jobs
//  GET  /jobs/{id}/state
//  GET  /jobs/{id}/config
//  GET  /jobs/{id}/policyData
//  PUT  /jobs/{id}/state        {stateName:'A'}
//  PUT  /jobs/{id}/policyData
//  PATCH /jobs/{id}/policyData   { ...model }

// other resources all under static cacheable data service.  only GET's.  no PUT/POST/PATCH/DELETES by app
// but editor will need them in the future.
//     GET /data/vehicleManufacturers
//     GET /data/wiringTypes?country=CA
//     GET /data/roofType?q=metal&sort=-alphabetic
//     POST /data/vehichleManufacturer   {name:'BMW', ...}
//     these are all collections.  no PUT's or PATCHes
//     All under cached services.   when does cache expire?   if configuration changes (underlying DB or .properties or whatever).
//     Spring can mark this as not cached but what about browser? each data service will take a version key stored in DB.
//     /data/vehichleManufacturer client needs to get this. return it in patch.  but how?

// use WebSockets to push out new version of data.    subscribe /data   -->   vehichleManufacturers=<timeInMs>
// add that to jobConfig.  it will be sent to all /data requests.
// job service will include data keys.  These are updated every time a service needs to be cleared from cache.

//  other config is immutable once it's inflight.   existing jobs have config that will NEVER change.

@RestController
@RequestMapping("/job")
public class JobController {

    @Inject private JobService jobService;

    @RequestMapping(value = "{jobId}", method = RequestMethod.PATCH)
    @ResponseBody
    public void action( @PathVariable("id") String id, @RequestParam(value="action", defaultValue="noAction") String action, @RequestBody Job job) {
        // get job.
        // get action based on jobs current state.
        // resolve service(s)                            ,
        // iterate { result.merge( service(job) ); }
        // return result;   include patch of job. (store original version and get current version).
        // response should include link to new resource if something other than state change.
        //  or just a patch of the changed fields 200:{currentState:'bar'}
        // handle all errors?
    }

    //   POST ./job?type=auto&policy=873       policy & version are optional
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JobWithConfig> create(@RequestParam(value="type", defaultValue="") String type,
                                @RequestParam(value="custInfo", defaultValue="") String custInfoId) {
        if (type=="") {
            // TODO error..invalid type.
        }
        JobWithConfig jobWithConfig = jobService.create(type);

        return new ResponseEntity<JobWithConfig>(jobWithConfig, HttpStatus.CREATED);
    }

    
    // Content-type:should ask for .json+merge-patch.

    // return new state.    actionButtonConfig = { 'SUBMIT', ['myService',...]}
    // return new state.    actionButtonConfig = { 'SUBMIT'}   if no service specified, uses naming convention.   i.e. calls "SubmitService".
    // need to find current form and find its config.


}
