package api.tests;

import api.dto.Booking;
import api.dto.CreateBookingResponse;
import api.service.BookingService;
import com.frameworkium.core.api.tests.BaseAPITest;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class BookerTest extends BaseAPITest {

    @Test
    public void createBookingTest() {
        BookingService service = new BookingService();
        Booking booking = Booking.newInstance();

        CreateBookingResponse bookingResponse = service.createBooking(booking);

        assertThat(bookingResponse.booking)
                .isEqualTo(booking);

        assertThat(service.getBooking(bookingResponse.bookingid))
                .isEqualTo(booking);
    }
}
