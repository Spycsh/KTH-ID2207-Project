package com.sep.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sep.system.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



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

    @RequestMapping("/createEvent")
    public String createEventPage(){
        return "createEventRequest";
    }

    @PostMapping(value ="/createEventRequest")
    public String createEvent(@RequestParam("clientName") String clientName, @RequestParam("eventType") String eventType,
    @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate,
    @RequestParam("perferences") String perferences,@RequestParam("expectedBudget") int expectedBudget,
    Map<String, Object> map){

      Event event = new Event(clientName,eventType,beginDate,endDate,perferences,expectedBudget);

      
      eventRepository.save(event);

      return "redirect:/createEvent";
      
    }


  //  @RequestMapping("/insertEventData")
  //   public String addTestEvent() {
  //   Event event = new Event();
  //   event.setClientId(1);
  //   event.setExpectedBudget(666);
  //   event.setStatus("new");
  //   eventRepository.save(event);
  //   return "insertSuccess";
  // }

}
