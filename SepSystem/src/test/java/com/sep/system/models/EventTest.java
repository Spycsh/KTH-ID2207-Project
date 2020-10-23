package com.sep.system.models;

import com.sep.system.controller.EventController;
import com.sep.system.controller.EventRepository;
import com.sep.system.model.Event;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EventTest {
    Event event;

    @Autowired
    private EventRepository eventRepository;


    EventController eventController = new EventController();

    //test for creating an event
    @Test
    public void createEventTest(){
        event = new Event("testclient", "party", "2020-10-22", "2020-10-23",
                "non-smoke", 10000, "Please organize it as soon as possible");
      
        eventController.addEventInDB(event);

        Event e = eventRepository.findByClientName("testclient").get(0);
        Assert.assertEquals(e.getClientName(), "testclient");
        Assert.assertEquals(e.getEventType(), "party");
        Assert.assertEquals(e.getBeginDate(), "2020-10-22");
        Assert.assertEquals(e.getEndDate(), "2020-10-23");
        Assert.assertEquals(e.getPreferences(), "non-smoke");
        Assert.assertEquals(e.getExpectedBudget(), 10000);
        Assert.assertEquals(e.getDescription(), "Please organize it as soon as possible");
    }

    //test for editing an event
    @Test
    public void editEventTest(){
        Event e = eventRepository.findByClientName("testclient").get(0);
        eventController.updateEventInDB("approve", "senior customer service manager", e, null);

        Event updatedEvent = eventRepository.findByClientName("testclient").get(0);
        Assert.assertEquals("SCSapproved", updatedEvent.getStatus());
        
        
        
        eventRepository.deleteById(updatedEvent.getId());
    }

    // @Test
    // public void deleteEventTest(){
    //     List<Event> events = eventRepository.findByClientName("testEvent");
    //     if(events.size()>0) {
    //         Event e = events.get(0);
    //         eventRepository.deleteById(e.getId());
    //     }
    //     Assert.assertEquals(0, eventRepository.findByClientName("testEvent").size());
    // }
}
