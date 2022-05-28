package com.springhow.examples.drools;

import com.springhow.examples.drools.domain.OrderRequest;
import com.springhow.examples.drools.helper.CustomKieContainer;
import com.springhow.examples.drools.helper.KieContainerType;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/controller/duplicate")
public class DecisionControllerDuplicate {

    @Autowired
    private CustomKieContainer customKieContainer;

    @PostMapping("/discount")
    private OrderRequest getDiscountPercent(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    @PostMapping("/discount1")
    private OrderRequest getDiscountPercent1(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    @PostMapping("/discount2")
    private OrderRequest getDiscountPercent2(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    @PostMapping("/discount3")
    private OrderRequest getDiscountPercent3(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }
}
