package com.sep.system.models;

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

    @Test
    public void createEventTest(){
        event = new Event("testclient", "party", "2020-10-22", "2020-10-23",
                "non-smoke", 10000, "Please organize it as soon as possible");
        eventRepository.save(event);
        Event e = eventRepository.findByClientName("testclient").get(0);
        Assert.assertEquals(e.getClientName(), "testclient");
        Assert.assertEquals(e.getEventType(), "party");
        Assert.assertEquals(e.getBeginDate(), "2020-10-22");
        Assert.assertEquals(e.getEndDate(), "2020-10-23");
        Assert.assertEquals(e.getPreferences(), "non-smoke");
        Assert.assertEquals(e.getExpectedBudget(), 10000);
        Assert.assertEquals(e.getDescription(), "Please organize it as soon as possible");
    }

    @Test
    public void editEventTest(){
        Event e = eventRepository.findByClientName("testclient").get(0);
        e.setStatus("SCSapproved");
        e.setExpectedBudget(12000);
        Assert.assertEquals(12000, e.getExpectedBudget());
        Assert.assertEquals("SCSapproved", e.getStatus());
    }

    @Test
    public void deleteEventTest(){
        List<Event> events = eventRepository.findByClientName("testEvent");
        if(events.size()>0) {
            Event e = events.get(0);
            eventRepository.deleteById(e.getId());
        }
        Assert.assertEquals(0, eventRepository.findByClientName("testEvent").size());
    }
}
