package com.brovada.job;

import com.brovada.document.Event;
import com.brovada.document.Job;
import com.brovada.document.JobState;
import com.brovada.document.StateTable;
import com.brovada.document.StateTransitions;

public class JobClient {

    private Job job;


    public JobClient() {
    }

    public JobClient(Job job) {
        this.job = job;
    }

    public JobState start() {
        // assert state is INITIAL.
        String initialState = job.getConfig().getStateTable().getInitialState();
        job.setState(initialState);
        return job.getState();

        // fire initial event.
        // I should save the job every time I update the state.  create aspect around
        // all services that take in job.
        // what is the initial event that is fired?
    }

    private JobState onEvent(Event event) {
        String currentState = job.getState().getName();
        StateTable stateTable = job.getConfig().getStateTable();
        StateTransitions transitions = stateTable.get(currentState);
        for (Event e:transitions.keySet()) {
            if (e.matches(event)) {
                System.out.println("matched event " + e);
                System.out.println("changing state to " + transitions.get(e));
                return doTransition(transitions.get(e));
            }
        }
        if (transitions.getCatchAll()!=null) {
            return doTransition(transitions.getCatchAll());
        }
        throw new IllegalArgumentException("can't find state transtion for " + event + ". Must be one of " + transitions.getAllPossibleStates());

    }

    private JobState doTransition(String state) {
        job.setState(state);
        return job.getState();
    }

    protected JobState onEvent(int code) {
        return onEvent(new Event(code));
    }

    protected JobState onEvent(int httpCode, int code) {
        return onEvent(new Event(httpCode,code));
    }


}
