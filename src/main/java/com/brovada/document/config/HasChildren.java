package com.brovada.document.config;

import java.util.List;

public interface HasChildren {

    List<? extends ComponentConfig> getChildren();

}
