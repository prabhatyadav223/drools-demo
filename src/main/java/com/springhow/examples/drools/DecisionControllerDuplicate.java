package com.springhow.examples.drools;

import com.springhow.examples.drools.domain.OrderRequest;
import com.springhow.examples.drools.helper.CustomKieContainer;
import com.springhow.examples.drools.helper.KieContainerType;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/controller2")
public class DecisionControllerDuplicate {

    @Autowired
    private CustomKieContainer customKieContainer;

    @PostMapping("/duplicate/discount")
    private OrderRequest getDiscountPercentDuplicate(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    @PostMapping("/duplicate/discount1")
    private OrderRequest getDiscountPercentDuplicate1(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    @PostMapping("/duplicate/discount2")
    private OrderRequest getDiscountPercentDuplicate2(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    @PostMapping("/duplicate/discount3")
    private OrderRequest getDiscountPercentDuplicate3(@RequestBody OrderRequest orderRequest) {
        KieSession kieSession = customKieContainer.getKieContainer(KieContainerType.SECONDARY).newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderRequest;
    }

    private void test(){
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
        System.out.printf("demo");
    }
}
