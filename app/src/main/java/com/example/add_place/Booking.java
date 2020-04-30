package com.example.add_place;

public class Booking {
    private int userId;
    private String userName,rooms;
    private long booked,bookFinished;

    public Booking() {
    }

    public Booking(String userName, String rooms, long booked, long finished) {
        this.userName = userName;
        this.rooms = rooms;
        this.booked = booked;
        this.bookFinished = finished;
    }

    public Booking(int id, String userName, String rooms, long booked, long finished) {
        this.userId = id;
        this.userName = userName;
        this.rooms = rooms;
        this.booked = booked;
        this.bookFinished = finished;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getRooms() {
        return rooms;
    }

    public long getBooked() {
        return booked;
    }

    public long getBookFinished() {
        return bookFinished;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public void setBooked(long booked) {
        this.booked = booked;
    }

    public void setBookFinished(long bookFinished) {
        this.bookFinished = bookFinished;
    }
}
