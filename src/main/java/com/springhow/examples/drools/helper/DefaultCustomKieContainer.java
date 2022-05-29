package com.springhow.examples.drools.helper;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DefaultCustomKieContainer implements CustomKieContainer {

    private final KieServices kieServices = KieServices.Factory.get();
    private KieContainer primaryKieContainer;
    private KieContainer secondaryKieContainer;


    public DefaultCustomKieContainer() {
        primaryKieContainer = getDefaultKieContainer();
        secondaryKieContainer = primaryKieContainer;
    }

    @Override
    public KieContainer getKieContainer(KieContainerType kieContainerType) {

        switch (kieContainerType) {
            case PRIMARY:
                return primaryKieContainer;
            case SECONDARY:
                return secondaryKieContainer;
        }
        return null;
    }

    private KieContainer getDefaultKieContainer() {
        /*KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("discount.drl"));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());*/

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newFileResource(new File("/Users/micro/IdeaProjects/drools-demo/src/main/resources/discount_secondary.drl")));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        KieScanner kieScanner= kieServices.newKieScanner(kieContainer);
        kieScanner.scanNow();
        kieScanner.start(100000L);
        return kieContainer;
    }

    public void setSecondaryKieContainer(KieContainer secondaryKieContainer) {
        this.secondaryKieContainer = secondaryKieContainer;
    }
}
