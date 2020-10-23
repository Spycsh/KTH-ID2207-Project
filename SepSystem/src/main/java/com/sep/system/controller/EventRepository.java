package com.sep.system.controller;
import com.sep.system.model.Employee;
import com.sep.system.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//for connecting to the database
public interface EventRepository extends JpaRepository<Event, Integer> {
    public List<Event> findByClientName(String clientName);

}

