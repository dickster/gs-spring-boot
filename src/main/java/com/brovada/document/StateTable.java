package com.brovada.document;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class StateTable extends HashMap<String, StateTransitions> {

    private String initialState;

  public StateTable() {
      
  }

  public StateTable withState(@Nonnull String state, @Nonnull StateTransitions transitions) {
      if (initialState==null) {
          initialState = state;
      }
      // assert doesn't exist.
      put(state, transitions);
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
      // TODO : get the first state in the table (chronologically - not alphabetically)
      return "A";
  }


}
