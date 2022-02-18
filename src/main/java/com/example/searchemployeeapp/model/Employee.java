package com.example.searchemployeeapp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {
    private String id;
    private String name;
    private String joinedDate;
    private String callNumber;
    private BigDecimal limitReimburs;
    private String createdDate;
    private String updatedDate;

    public Employee() {
    }

    public Employee(String name, String joinedDate, String callNumber, BigDecimal limitReimburs) {
        this.name = name;
        this.joinedDate = joinedDate;
        this.callNumber = callNumber;
        this.limitReimburs = limitReimburs;
    }

    public Employee(String id, String name, String joinedDate, String callNumber, BigDecimal limitReimburs,
            String createdDate, String updatedDate) {
        this.id = id;
        this.name = name;
        this.joinedDate = joinedDate;
        this.callNumber = callNumber;
        this.limitReimburs = limitReimburs;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public BigDecimal getLimitReimburs() {
        return limitReimburs;
    }

    public void setLimitReimburs(BigDecimal limitReimburs) {
        this.limitReimburs = limitReimburs;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", joinedDate=" + joinedDate +
                ", callNumber= " + callNumber + ", limitReimburs= " + limitReimburs +
                ", createdDate= " + createdDate + ", updatedDate=" + updatedDate + "]";
    }

}
