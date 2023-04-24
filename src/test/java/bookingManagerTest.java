import org.encoracoding.test.BookingManager;
import org.encoracoding.test.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class bookingManagerTest {
    private BookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        // create a new BookingManager object before each test
        bookingManager = new BookingManager(10);
    }

    @Test
    public void testKeepBooking() {

        assertTrue(bookingManager.keepBooking("John", 5, "2023-05-01"));
        assertFalse(bookingManager.keepBooking("John", 5, "2023-05-01"));
        assertTrue(bookingManager.keepBooking("Jane", 6, "2023-05-01"));
        assertFalse(bookingManager.keepBooking("John", 6, "2023-05-01"));
    }

    @Test
    public void testFindBookingsByGuest() {

        bookingManager.keepBooking("John", 5, "2023-05-01");
        bookingManager.keepBooking("John", 7, "2023-05-02");
        bookingManager.keepBooking("John", 8, "2023-05-03");
        List<Booking> bookings = bookingManager.findBookingsByGuest("John");
        assertEquals(3, bookings.size());
        assertEquals("John", bookings.get(0).getGuestName());
        assertEquals(5, bookings.get(0).getRoomNumber());
        assertEquals("2023-05-01", bookings.get(0).getDate());
        assertEquals("John", bookings.get(1).getGuestName());
        assertEquals(7, bookings.get(1).getRoomNumber());
        assertEquals("2023-05-02", bookings.get(1).getDate());
        assertEquals("John", bookings.get(2).getGuestName());
        assertEquals(8, bookings.get(2).getRoomNumber());
        assertEquals("2023-05-03", bookings.get(2).getDate());
    }
}
