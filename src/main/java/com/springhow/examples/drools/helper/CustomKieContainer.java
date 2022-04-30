package com.springhow.examples.drools.helper;

import org.kie.api.runtime.KieContainer;

public interface CustomKieContainer {

    KieContainer getKieContainer(KieContainerType kieContainerType);
}
