package org.encoracoding.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookingManager {
    private final int numRooms;
    private final Map<String, List<Booking>> bookingsByGuest;

    public BookingManager(int numRooms) {
        this.numRooms = numRooms;
        this.bookingsByGuest = new HashMap<>();
    }

    public synchronized boolean keepBooking(String guestName, int roomNumber, String date) {
        if (isRoomAvailable(roomNumber, date)) {
            Booking booking = new Booking(guestName, roomNumber, date);
            List<Booking> bookings = bookingsByGuest.getOrDefault(guestName, new ArrayList<>());
            bookings.add(booking);
            bookingsByGuest.put(guestName, bookings);
            return true;
        } else {
            return false;
        }
    }


private synchronized boolean availableRooms(int roomNumber, String date) {
    if (roomNumber < 1 || roomNumber > numRooms) {
        return false;
    }
    List<Booking> bookings = bookingsByGuest.getOrDefault(roomNumber, new ArrayList<>());
    for (Booking booking : bookings) {
        if (booking.getDate().equals(date)) {
            return false;
        }
    }
    return true;
}
    public synchronized List<Booking> findBookingsByGuest(String guestName) {
        return bookingsByGuest.getOrDefault(guestName, new ArrayList<>());
    }

    private boolean isRoomAvailable(int roomNumber, String date) {

        for (List<Booking> bookings : bookingsByGuest.values()) {
            for (Booking booking : bookings) {
                if (booking.getRoomNumber() == roomNumber && booking.getDate().equals(date)) {
                    return false;
                }
            }
        }
        return true;
    }
}
