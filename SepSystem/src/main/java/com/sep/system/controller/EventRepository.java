package com.sep.system.controller;
import com.sep.system.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Integer> {
}

