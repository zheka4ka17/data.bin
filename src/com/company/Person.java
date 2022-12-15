package com.company;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private List<String> emails = new LinkedList<>();

    public Person(){}


    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void addEmail(String email){
        emails.add(email);

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emails=" + emails +
                '}';
    }
}
