package org.encoracoding.test;

public class Booking {

    private final String guestName;
    private final int roomNumber;
    private final String date;

    public Booking(String guestName, int roomNumber, String date) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.date = date;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getDate() {
        return date;
    }

}
