package com.arrangement.model;

public class Event {

    private Long id;
    private String title;
    private int capacity;

    public Event() {
    }

    public Event(Long id, String title, int capacity) {
        this.id = id;
        this.title = title;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}