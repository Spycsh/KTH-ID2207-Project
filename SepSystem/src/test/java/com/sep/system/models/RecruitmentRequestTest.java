package com.sep.system.models;

import com.sep.system.controller.RecruitmentRequestRepository;
import com.sep.system.model.RecruitmentRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class RecruitmentRequestTest {
    RecruitmentRequest recruitmentRequest;

    @Autowired
    private RecruitmentRequestRepository recruitmentRequestRepository;

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

    @Test
    public void editRecruitmentRequestTest(){
        RecruitmentRequest e = recruitmentRequestRepository.findByRequestingDept("testapartment").get(0);
        e.setStatus("HRCommented");
        e.setCommentFromHR("OKay.");
        Assert.assertEquals("HRCommented", e.getStatus());
        Assert.assertEquals("OKay.", e.getCommentFromHR());
    }

    @Test
    public void deleteRecruitmentRequestTest(){
        List<RecruitmentRequest> rr = recruitmentRequestRepository.findByRequestingDept("testapartment");
        if(rr.size()>0) {
            RecruitmentRequest r = rr.get(0);
            recruitmentRequestRepository.deleteById(r.getId());
        }
        Assert.assertEquals(0, recruitmentRequestRepository.findByRequestingDept("testapartment").size());
    }
}
