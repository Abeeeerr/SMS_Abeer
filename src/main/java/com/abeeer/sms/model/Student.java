package com.abeeer.sms.model;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private String email;
    private String grade;
    private String section;
    private Date dateOfBirth;
    private String address;
    private int parentID;

    public Student(int id, String name, String email, String grade, String section, Date dateOfBirth, String address, int parentID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.section = section;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.parentID = parentID;
    }

    public Student(String name, String email, String grade, String section, Date dateOfBirth, String address, int parentID) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.section = section;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.parentID = parentID;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getGrade() { return grade; }
    public String getSection() { return section; }
    public Date getDateOfBirth() { return dateOfBirth; }
    public String getAddress() { return address; }
    public int getParentID() { return parentID; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setSection(String section) { this.section = section; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setAddress(String address) { this.address = address; }
    public void setParentID(int parentID) { this.parentID = parentID; }
}
