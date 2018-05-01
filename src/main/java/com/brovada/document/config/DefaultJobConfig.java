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
                                .withTransition("200", "B")
                                .withTransition("404", "C")
                        )
                .withState("B",
                        new StateTransitions() .withTransition("200", "A")
                    )                                                                
                .withState("C",
                        new StateTransitions() .withTransition("200", "A")
                    )
                .withInitialState("A")

        )  ;
    }
}
