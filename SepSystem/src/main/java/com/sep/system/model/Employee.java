package com.sep.system.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Employee {
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Id
private int id;
private String name;
private String password;
private String role;

public Employee(){
    
}

public Employee(int id, String name, String password, String role){
    this.id = id;
    this.name = name;
    this.role = role;
    this.password = password;

}


public Employee( String name, String role, String password){
    
    this.name = name;
    this.role = role;
    this.password = password;

}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}



public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

}
