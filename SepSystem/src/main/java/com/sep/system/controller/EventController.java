package com.sep.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sep.system.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Integer.parseInt;


@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/eventManagement")
    public String eventManagement(Map<String, Object> map) {
        List<Event> eventList = eventRepository.findAll();
        System.out.println(eventList);
        // for(int i=0;i<9;i++)
        // {

        //     eventList.add(new Event());

        // }

        map.put("eventlist", eventList);
        return "eventManagement";
    }


    @PostMapping(value = "/editEvent")
    public String editEvent(@RequestParam("eventId") String eventId, Map<String, Object> map){
//        List<Event> event = eventRepository.findById(eventId);
        System.out.println(eventId);

        Event event = eventRepository.findById(parseInt(eventId)).get();

        map.put("event", event);

        return "editEventRequest";

    }

    @RequestMapping("/createEvent")
    public String createEventPage(){
        return "createEventRequest";        // go to createEventRequest.html
    }

    @PostMapping(value = "/editEventRequest")
    public String editEvent(HttpServletRequest request, @RequestParam("eventId") String eventId, @RequestParam("comment") String comment, @RequestParam("expectedBudget") int expectedBudget,
                            @RequestParam("choice") String choice){
        System.out.println(eventId);

        // get current role
        String role = (String) request.getSession().getAttribute("role");
        // get the event currently dealt with
        Event event = eventRepository.findById(parseInt(eventId)).get();

        if(choice.equals("reject")){
            event.setStatus("Closed");
        }else{
            switch (role) {
                case "admin manager":
                    if(event.getStatus().equals("SCSapprove"))
                        event.setStatus("AMapprove");
                    break;
                case "senior customer service manager":
                    if(event.getStatus().equals("draft"))
                        event.setStatus("SCSapprove");
                    break;
                case "financial manager":
                    event.setComment(comment);
                    event.setExpectedBudget(expectedBudget);
                    break;
            }
        }

        eventRepository.save(event);

        return "redirect:/eventManagement";


    }


    @PostMapping(value = "/createEventRequest")
    public String createEvent(@RequestParam("clientName") String clientName, @RequestParam("eventType") String eventType,
                              @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate,
                              @RequestParam("preferences") String preferences, @RequestParam("expectedBudget") int expectedBudget,
                              @RequestParam("description") String description,
                              Map<String, Object> map) {

        Event event = new Event(clientName, eventType, beginDate, endDate, preferences, expectedBudget, description);

        eventRepository.save(event);

        return "redirect:/eventManagement";     // must use redirect here

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
