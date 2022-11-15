package api.service;

import api.constant.BookerEndpoint;
import com.frameworkium.core.api.services.BaseService;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public abstract class AbstractBookingService extends BaseService {
    @Override
    protected RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .baseUri(BookerEndpoint.BASE_URI.getUrl())
                .relaxedHTTPSValidation()
                .log().all()
                .contentType("application/json")
                .accept("application/json");
    }

    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response()
                .statusCode(HttpStatus.SC_OK);
    }

    protected ExtractableResponse post(Object body, String url) {
        return request(Method.POST, body, url);
    }
}
