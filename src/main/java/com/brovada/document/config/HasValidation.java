package com.brovada.document.config;

import java.util.List;
import java.util.Optional;

public interface HasValidation {

    default Optional<List<String>> getValidators() { return Optional.empty(); };

}
