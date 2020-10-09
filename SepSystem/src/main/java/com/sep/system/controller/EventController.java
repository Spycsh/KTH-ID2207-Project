package com.sep.system.controller;


import java.util.List;
import java.util.Map;

import com.sep.system.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;
  @RequestMapping("/eventManagement")
    public String eventManagement(Map<String, Object> map){
        List<Event> eventList= eventRepository.findAll(); 
        System.out.println(eventList);
        // for(int i=0;i<9;i++)
        // {

        //     eventList.add(new Event());

        // }
        
        map.put("eventlist",eventList);
        return "eventManagement";
    }

   @RequestMapping("/insertEventData")
    public String addEvent() {
    Event event = new Event();
    event.setClientId(1);
    event.setExpectedBudget(666);
    event.setStatus("new");
    eventRepository.save(event);
    return "insertSuccess";
  }

}
