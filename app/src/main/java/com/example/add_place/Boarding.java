package com.example.add_place;

public class Boarding {
    private int id;
    private String name,contact,address,description;
    private long started,finished;

    public Boarding(){

    }

    public Boarding(int id, String name, String contact, String address, String description, long started, long finished) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.description = description;
        this.started = started;
        this.finished = finished;
    }

    public Boarding(String name, String contact, String address, String description, long started, long finished) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.description = description;
        this.started = started;
        this.finished = finished;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
