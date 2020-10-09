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
private Date  beginDate;
private Date endDate;
private String perferences;
private int expectedBudget;
private String status;
private String comment;


public Event(){
    this.id = 1;
    this.clientId = 1;
    this.clientName = "sb";
    this.eventType = "sb";
    this.beginDate = new Date();
    this.endDate = new Date();
    this.perferences = "sb";
    this.expectedBudget = 123;
    this.status = "sv";
    this.comment = "sb";

}


// Event(String recordNumber,String clientId,String clientName,String eventType,Date beginDate,Date endDate,
// String perferences,int expectedBudget,String status,String comment){
//     this.id = recordNumber;
//     this.clientId = clientId;
//     this.clientName = clientName;
//     this.eventType = eventType;
//     this.beginDate = beginDate;
//     this.endDate = endDate;
//     this.perferences = perferences;
//     this.expectedBudget = expectedBudget;
//     this.status = status;
//     this.comment = comment;


// }

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

public Date getBeginDate() {
    return beginDate;
}

public void setBeginDate(Date beginDate) {
    this.beginDate = beginDate;
}

public Date getEndDate() {
    return endDate;
}

public void setEndDate(Date endDate) {
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



}