package com.sep.system.controller;


import com.sep.system.model.RecruitmentRequest;
import com.sep.system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//for connecting to the database
public interface RecruitmentRequestRepository extends JpaRepository<RecruitmentRequest, Integer>{

    List<RecruitmentRequest> findByRequestingDept(String requestingDept);
}
