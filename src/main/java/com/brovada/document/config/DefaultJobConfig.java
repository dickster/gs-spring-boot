package com.brovada.document.config;

import com.brovada.document.JobConfig;
import com.brovada.document.StateTable;
import com.brovada.document.StateTransitions;

public class DefaultJobConfig extends JobConfig {

    public DefaultJobConfig() {
        super();
        setName("auto");
        setStateTable(new StateTable()
                .withState("A",
                        new StateTransitions()
                                .withTransition(200, "B")
                                .withTransition(400,499, "C")
                                .withCatchAllTransition("E")
                        )
                .withState("B",
                        new StateTransitions()
                                .withTransition(11, "C")
                    )
                .withState("C",
                        new StateTransitions() 
                                .withTransition(33, "A")
                    )
                .withState("E",
                    new StateTransitions()
                            .withTransition(-1, "A"))
                .withInitialState("A")

        )  ;
    }
}
