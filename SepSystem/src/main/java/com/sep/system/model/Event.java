package com.sep.system.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Id
private int id;
private int clientId;
private String clientName;
private String eventType;
private String  beginDate;
private String endDate;
private String perferences;
private int expectedBudget;
private String status;
private String comment;


public Event(){
}


public Event(String clientName,String eventType,String beginDate,String endDate,
String perferences,int expectedBudget){
    this.clientId = 0;
    this.clientName = clientName;
    this.eventType = eventType;
    this.beginDate = beginDate;
    this.endDate = endDate;
    this.perferences = perferences;
    this.expectedBudget = expectedBudget;
    this.status = "draft";
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getClientId() {
    return clientId;
}

public void setClientId(int clientId) {
    this.clientId = clientId;
}

public String getClientName() {
    return clientName;
}

public void setClientName(String clientName) {
    this.clientName = clientName;
}

public String getEventType() {
    return eventType;
}

public void setEventType(String eventType) {
    this.eventType = eventType;
}

public String getBeginDate() {
    return beginDate;
}

public void setBeginDate(String beginDate) {
    this.beginDate = beginDate;
}

public String getEndDate() {
    return endDate;
}

public void setEndDate(String endDate) {
    this.endDate = endDate;
}

public String getPerferences() {
    return perferences;
}

public void setPerferences(String perferences) {
    this.perferences = perferences;
}

public int getExpectedBudget() {
    return expectedBudget;
}

public void setExpectedBudget(int expectedBudget) {
    this.expectedBudget = expectedBudget;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public String getComment() {
    return comment;
}

public void setComment(String comment) {
    this.comment = comment;
}

@Override
public String toString() {
    return "Event [beginDate=" + beginDate + ", clientId=" + clientId + ", clientName=" + clientName + ", comment="
            + comment + ", endDate=" + endDate + ", eventType=" + eventType + ", expectedBudget=" + expectedBudget
            + ", id=" + id + ", perferences=" + perferences + ", status=" + status + "]";
}



}