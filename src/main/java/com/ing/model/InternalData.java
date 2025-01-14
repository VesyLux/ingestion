package com.ing.model;

import java.util.ArrayList;
import java.util.List;

public class InternalData {
    private String roomId;
    private String startTimeUTC;
    private String companyId;
    private final List<String> messages = new ArrayList<>();

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(String startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    @Override
    public String toString() {
        return "InternalData{" +
                "roomId='" + roomId + '\'' +
                ", startTimeUTC='" + startTimeUTC + '\'' +
                ", companyId='" + companyId + '\'' +
                ", messages=" + messages +
                '}';
    }
}