package com.brovada.service;

import com.brovada.document.DocumentReference;
import com.brovada.document.JobConfig;
import com.brovada.document.JobData;
import com.brovada.document.JobState;
import com.brovada.document.JobWithConfig;
import com.brovada.document.Version;
import com.brovada.repository.JobConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

import static com.brovada.document.JobBuilder.aJob;
import static com.brovada.document.JobWithConfigBuilder.aJobWithConfig;

// POST ../job/123/validation    // automatically updates job data  (equivalent to PUT : job/123/data  {} )



//  POST ../job/123/validation   {returns whatever...client responsible for parsing and running workflow).
//  POST ../job/123/foobar       if changes policy, then return a link to new data.
//  PUT ../job/123               saves newest version.  (for drafts)
//

//actionConfig = {remote:
//  {host:'www.insuranceCo'
//    url:someResource
//    parameters:[{name:'color', source:'policy.insured.carColour'}, ...]
//    mapping:{ 'foo':'bar'  etc.... source:foo --> dest:bar   https://www.npmjs.com/package/object-mapper }
//    name:'RADAR'  // some unique name. at least unique within form/state.  will set pending.RADAR=true.
//    resultMapping: { 'externalCode':'internalCode' ...     to translate results into standard results.
//   }

//  local:{name:validation    // ==> ./job/{id}/validation
//    params: [as above]
//    mapping: [as above]
//    name: [as above]

// client: {
//  result: {http:200, code:0}    or result : 0   or result: {code:0}
//  wrap it up in an immediate promise.
// }



// NOTE : action buttons need to have some sort of timer implemented.  spinner applied to button/overlay/
// or go to a temporary screen with msgs.   need to configure a screen that waits on service
// polling button - waits on condition.   e.g. data.calculating=true --> false
// .: action button creates state = inflight.<action> = true.  on complete pending.<action> = false
// .: UI can be designed with v-if's   (how?  .: a section/form must be able to have configurable bizLogic)
// can have a parameterized (templated) progress page.   relies on inflight.<action> and calls workflow(configuredStatus)

//  {
//      job: {  config & settings }   immutable
//      state: {}   changes via action.
//      data: {}    changes on client side. sent on submit or other actions.
//      dataKeys: {}   can change every time you load.  not to be changed by any service/client.  only by editor.
//  }


// create job =
//   load config.
//   load translations
//   translate
//   load settings based on locale (date format etc..)
//   load data keys     e.g.   keys['cities'] = 'v6'   (or just 6)
//   load policy   (latest version)
//   initialize state - config should have start state defined.
//   do the translations.

// once a policy is used by a job, it shouldn't be modified outside.  mark it as being locked by job (jobId=x)
// OR consider creating a job even if you only need a policy.   that's valid.
//  .: create Policy = create empty job   {config:null,  policy:{....}, state:null, dataKeys:null}

// have a policy collection.  when you create a job based on a policy, it is copied into job.  and stores it's initial reference.
//   (maybe call it quoteInfo  or jobData--these are temporary holding spots for customer info.  should never be needed?
//  just include it in job!   (maybe have a customer info DB?)
// e.g. BestAdvice POST:  ../quoteInfo   {stuff}    clone it.
// for convenience, let jobservice do both of these calls for you.
// PUT :  ./job/347/data   {newData}


@Service
public class JobService {

    @Autowired
    private JobConfigRepository jobConfigRepository;

    
    //   POST ./job?type=auto:3.4.4973&policy=234:1.23.874       version is optional for both parameters.
    //   POST ./job?typeId=2857343        "
    //   PATCH ./job/123/data     {data}
    //   PATCH ./job/123/state    {action:'bind', payload:?}    returns new state & possibly a link if data has changed.

    public JobWithConfig create(String jobName) {
        return create(jobName, null, Locale.getDefault());
    }

    // allow client to override locale based settings (localization strings, formatting, currency etc..)
    //  later on via another service.    PATCH ./job/185/options    {  dateFormat:'yyyy-mm-dd' etc.. }

    // PUT ./job/185/policyData {data:...} after creation to set data.
    // or include the policyData ID in the request.
    
    // maybe PUT ./job/273/work?trigger=NEXT&name=validate  {job}    // create a work    responds with 200:   new url to job.  (or requires refresh flag)

    private JobWithConfig create(String jobName, Version version, Locale locale) {
        Optional<JobConfig> result = jobConfigRepository.findById(jobName);

        JobConfig jobConfig = result
                .orElseThrow(() -> new IllegalArgumentException("can't find job with id " + jobName));

        // note that actions should *never* be cached.  server should always respond with those headers.
//        Map<String,String> dataKeys = dataRepository.getCacheBustingKeys();
        return aJobWithConfig()
                .withConfig(jobConfig)
               // .withDataKeys(dataKeys)
                .withJob(aJob()
                        .withConfigRef(new DocumentReference(jobConfig.getId()))
                        .withData(new JobData())
                        .withState(new JobState())
                        .build())
                .build();
    }

//    public JobWithConfig find(String id) {
//        // update data keys here.
//        // TODO : bring in referenced config.
//        return jobRepository.find(id);
//    }


//    // need to return JobWithConfig, but when saving use Job.
//    // Job stores a versioned document reference to JobConfig.  (immutable.  can't change after creation).
//    public JobWithConfig create(String type, String policyId) {
//        Job job = create(type);
//        job.setJobData(jobDataRepository.find(policyId));
//        return job;
//    }
}
