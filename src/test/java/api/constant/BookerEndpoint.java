package api.constant;

import com.frameworkium.core.api.Endpoint;

public enum BookerEndpoint implements Endpoint {
    BASE_URI("https://restful-booker.herokuapp.com"),
    BOOKING("/booking"),
    BOOKING_ID("/booking/%d");

    private String url;

    BookerEndpoint(String url) {
        this.url = url;
    }

    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }
}
