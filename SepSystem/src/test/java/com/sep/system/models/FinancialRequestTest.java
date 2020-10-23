package com.sep.system.models;

import com.sep.system.controller.FinancialRequestRepository;
import com.sep.system.model.FinancialRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FinancialRequestTest {
    FinancialRequest financialRequest;

    @Autowired
    private FinancialRequestRepository financialRequestRepository;

    //test for creating the financial request
    @Test
    public void createFinancialRequestTest(){
//        String requestingDept, int eventId, int amount,
//        String reason, String status
        financialRequest = new FinancialRequest("testapartment", 2, 3000, "seafood and vegatables",
                "Draft");
        financialRequestRepository.save(financialRequest);
        FinancialRequest e = financialRequestRepository.findByRequestingDept("testapartment").get(0);
        Assert.assertEquals(e.getAmount(), 3000);
        Assert.assertEquals(e.getEventId(), 2);
        Assert.assertEquals(e.getStatus(), "Draft");
        Assert.assertEquals(e.getReason(), "seafood and vegatables");
    }

    //test for editing the financial request
    @Test
    public void editFinancialRequestTest(){
        FinancialRequest e = financialRequestRepository.findByRequestingDept("testapartment").get(0);
        e.setStatus("FMCommented");
        e.setCommentFromFM("OKay.");
        financialRequestRepository.save(e);
        FinancialRequest updatedRequest = financialRequestRepository.findByRequestingDept("testapartment").get(0);
        Assert.assertEquals("FMCommented", updatedRequest.getStatus());
        Assert.assertEquals("OKay.", updatedRequest.getCommentFromFM());

        financialRequestRepository.deleteById(updatedRequest.getId());
    }

//    @Test
//    public void deleteFinancialRequestTest(){
//        List<FinancialRequest> fr = financialRequestRepository.findByRequestingDept("testapartment");
//        if(fr.size()>0) {
//            FinancialRequest f = fr.get(0);
//            financialRequestRepository.deleteById(f.getId());
//        }
//        Assert.assertEquals(0, financialRequestRepository.findByRequestingDept("testapartment").size());
//    }
}
