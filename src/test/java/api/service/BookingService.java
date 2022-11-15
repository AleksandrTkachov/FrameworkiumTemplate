package api.service;

import api.constant.BookerEndpoint;
import api.dto.Booking;
import api.dto.CreateBookingResponse;

public class BookingService extends AbstractBookingService {

    public CreateBookingResponse createBooking(Booking booking) {
        return post(booking, BookerEndpoint.BOOKING.getUrl())
                .as(CreateBookingResponse.class);
    }

    public Booking getBooking(int id) {
        return get(BookerEndpoint.BOOKING_ID.getUrl(id))
                .as(Booking.class);
    }
}
