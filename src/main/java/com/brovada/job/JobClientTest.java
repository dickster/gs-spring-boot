package com.brovada.job;

import com.brovada.document.Job;
import com.brovada.document.JobState;
import com.brovada.document.config.DefaultJob;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobClientTest extends TestCase {

    private JobClient sut;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void test_SimpleJob() {

//        setStateTable(new StateTable()
//                        .withState("A",
//                                new StateTransitions()
//                                        .withTransition(200, "B")
//                                        .withTransition(range(400,499), "C")
//                                        .withCatchAllTransition("E")
//                        )
//                        .withState("B",
//                                new StateTransitions()
//                                        .withTransition(11, "C")
//                        )
//                        .withState("C",
//                                new StateTransitions()
//                                        .withTransition(33, "A")
//                        )
//                        .withState("E",
//                                new StateTransitions()
//                                        .withTransition(-1, "A"))
//                        .withInitialState("A")



        Job job = new DefaultJob();
        sut = new JobClient(job);
        assertEquals(JobState.INITIAL, job.getState());

        JobState state = sut.start();
        assertEquals("A", state.getName());

        state = sut.onEvent(200);
        assertEquals("B", state.getName());

        state = sut.onEvent(11);
        assertEquals("C", state.getName());

        state = sut.onEvent(33);
        assertEquals("A", state.getName());

        state = sut.onEvent(401);
        assertEquals("C", state.getName());

        state = sut.onEvent(33);
        assertEquals("A", state.getName());

        state = sut.onEvent(13123);    // test catch all.
        assertEquals("E", state.getName());
    }




}