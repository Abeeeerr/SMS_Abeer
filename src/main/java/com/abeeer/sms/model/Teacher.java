package com.abeeer.sms.model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Teacher {
    private int id;
    private String name;
    private String email;
    private String contact;
    private String qualification;
    private Date joinDate;
    private List<String> subjects;

    // Constructor with ID
    public Teacher(int id, String name, String email, String contact, String qualification, Date joinDate, List<String> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.qualification = qualification;
        this.joinDate = joinDate;
        this.subjects = subjects;
    }

    // Constructor without ID
    public Teacher(String name, String email, String contact, String qualification, Date joinDate, List<String> subjects) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.qualification = qualification;
        this.joinDate = joinDate;
        this.subjects = subjects;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }
    public String getQualification() { return qualification; }
    public Date getJoinDate() { return joinDate; }
    public List<String> getSubjects() { return subjects; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setContact(String contact) { this.contact = contact; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    // Convert List<String> subjects to a comma-separated string for DB
    public String getSubjectsAsCSV() {
        return String.join(",", subjects);
    }

    // Convert DB comma-separated string to List<String> for Java
    public static List<String> parseSubjectsFromCSV(String csv) {
        if (csv == null || csv.trim().isEmpty()) return new ArrayList<>();
        return Arrays.asList(csv.split(","));
    }

}
