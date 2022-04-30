package com.springhow.examples.drools;

import com.springhow.examples.drools.domain.OrderRequest;
import com.springhow.examples.drools.helper.CustomKieContainer;
import com.springhow.examples.drools.helper.KieContainerType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecisionController {

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
}
