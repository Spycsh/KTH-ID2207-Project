package com.sep.system.controller;


import com.sep.system.model.RecruitmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RecruitmentRequestRepository extends JpaRepository<RecruitmentRequest, Integer>{
    
}
