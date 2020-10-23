package com.sep.system.models;

import com.sep.system.controller.RecruitmentRequestRepository;
import com.sep.system.model.RecruitmentRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class RecruitmentRequestTest {
    RecruitmentRequest recruitmentRequest;

    @Autowired
    private RecruitmentRequestRepository recruitmentRequestRepository;

    //test for creating a new recruitment request
    @Test
    public void createRecruitmentRequestTest(){
//        String requestingDept, String contractType, String yearOfExperience, String jobTitle,
//                String description, String status
        recruitmentRequest = new RecruitmentRequest(
                "testapartment",
                "parttime",
                "at least 2",
                "data scientist", "good at C++/C/Golang",
                "Draft"
        );
        recruitmentRequestRepository.save(recruitmentRequest);
        RecruitmentRequest e = recruitmentRequestRepository.findByRequestingDept("testapartment").get(0);
        Assert.assertEquals(e.getJobTitle(), "data scientist");
        Assert.assertEquals(e.getStatus(), "Draft");
        Assert.assertEquals(e.getContractType(), "parttime");
        Assert.assertEquals(e.getYearOfExperience(), "at least 2");
    }


    //test for editing the recruitment request
    @Test
    public void editRecruitmentRequestTest(){
        RecruitmentRequest e = recruitmentRequestRepository.findByRequestingDept("testapartment").get(0);
        e.setStatus("HRCommented");
        e.setCommentFromHR("OKay.");
        recruitmentRequestRepository.save(e);

        RecruitmentRequest updatedReq = recruitmentRequestRepository.findByRequestingDept("testapartment").get(0);
        Assert.assertEquals("HRCommented", updatedReq.getStatus());
        Assert.assertEquals("OKay.", updatedReq.getCommentFromHR());

        recruitmentRequestRepository.deleteById(updatedReq.getId());
    }

//    @Test
//    public void deleteRecruitmentRequestTest(){
//        List<RecruitmentRequest> rr = recruitmentRequestRepository.findByRequestingDept("testapartment");
//        if(rr.size()>0) {
//            RecruitmentRequest r = rr.get(0);
//            recruitmentRequestRepository.deleteById(r.getId());
//        }
//        Assert.assertEquals(0, recruitmentRequestRepository.findByRequestingDept("testapartment").size());
//    }
}
