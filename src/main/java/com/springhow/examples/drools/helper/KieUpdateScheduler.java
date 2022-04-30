package com.springhow.examples.drools.helper;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

@Component
public class KieUpdateScheduler {

    @Autowired
    private DefaultCustomKieContainer defaultCustomKieContainer;

    private final KieServices kieServices = KieServices.Factory.get();
    private final KieResources kieResources = kieServices.getResources();



    @Scheduled(fixedDelay = 2*60*1000, initialDelay = 1000)
    public void updateSecondaryKieContainer(){
        System.out.println("updateSecondaryKieContainer"+ (new Date()));
        KieContainer defaultKieContainer = getDefaultKieContainer(new File("/Users/micro/IdeaProjects/drools-demo/src/main/resources/discount_secondary.drl"));
        defaultCustomKieContainer.setSecondaryKieContainer(defaultKieContainer);
    }

    private KieContainer getDefaultKieContainer(File file) {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(kieResources.newFileSystemResource(file, "UTF-8"));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }
}
