package com.sep.system.controller;

import java.util.List;

import com.sep.system.model.FinancialRequest;

import org.springframework.data.jpa.repository.JpaRepository;
public interface FinancialRequestRepository extends JpaRepository<FinancialRequest, Integer>{
   
}



