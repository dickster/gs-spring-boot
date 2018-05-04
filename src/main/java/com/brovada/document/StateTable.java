package com.brovada.document;

import com.google.common.collect.Lists;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;

public class StateTable extends HashMap<String, StateTransitions> {

    //stateTable.get("B") = {-1->E, 200->C, 201->D}
    // eg. A[0] => B
    //     B[-1] => E
    //     B[200] => C
    //     B[201] => D
    //     C[0] => D

  private String initialState;

  public StateTable() {
      
  }

  public StateTable withState(@Nonnull String state, @Nonnull StateTransitions transitions) {
      // assert doesn't exist.
      put(state, transitions);
      if (initialState==null) {
          withInitialState(state);
      }
       // add flag to create states referenced in transitions. 
      return this;
  }

  public StateTable withInitialState(@Nonnull String state) {
      if (!containsKey(state)) {
          throw new IllegalArgumentException("state table doesn't contain " + state);
      }
      this.initialState = state;
      return this;
  }

  public StateTable withState(String state) {
      withState(state, new StateTransitions());
      validate();
      return this;
  }

  public StateTable withStates(String... states) {
      for (String state:states) {
          withState(state, new StateTransitions());
      }
      return this;
  }

  public StateTable validate() {
      // the builder should call this!    .build() => validate(); return buildIt();
      //
      // make sure all transitions point to valid states.
      return this;
  }


  public String getInitialState() {
      return initialState;
  }


  public boolean isTerminalState(String state) {
      Collection<String> transitions = getTransitions(state);
      return transitions.size()==0;
  }

    private Collection<String> getTransitions(String state) {
      for (String s:keySet()) {
          if (state==s) {
            return get(s).getAllPossibleStates();
          }
      }
      return Lists.newArrayList();
    }

}
