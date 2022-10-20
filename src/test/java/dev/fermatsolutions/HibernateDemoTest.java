package dev.fermatsolutions;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import static io.micronaut.http.HttpStatus.NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;

class HibernateDemoTest extends BaseDatabaseTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testFindNonExistingUserReturns404() {
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, () ->
                httpClient.toBlocking().exchange(HttpRequest.GET("/users/1")));
        assertNotNull(thrown.getResponse());
        assertEquals(NOT_FOUND, thrown.getStatus());
    }
}
