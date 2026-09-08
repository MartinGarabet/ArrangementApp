package com.arrangement.model;

public class Registration {

    private Long id;
    private Long eventId;
    private String participantName;
    private String participantEmail;

    public Registration() {
    }

    public Registration(Long id, Long eventId, String participantName, String participantEmail) {
        this.id = id;
        this.eventId = eventId;
        this.participantName = participantName;
        this.participantEmail = participantEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantEmail() {
        return participantEmail;
    }

    public void setParticipantEmail(String participantEmail) {
        this.participantEmail = participantEmail;
    }
}