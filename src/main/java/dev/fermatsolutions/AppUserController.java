package dev.fermatsolutions;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;
import lombok.val;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

@Controller("/users")
@AllArgsConstructor
public class AppUserController {

    private final AppUserRepository appUserRepository;
    private final AddressRepository addressRepository;

    @Get("/{id}")
    Mono<AppUser> find(@PathVariable Long id) {
        return appUserRepository.findById(id);
    }

    @Post
    Mono<HttpResponse<AppUser>> save(@Body @Valid AppUserSaveCommand command) {
        val savedUser = AppUser.builder()
                .firstName(command.firstName())
                .lastName(command.lastName())
                .build();
        val savedAddress = Address.builder()
                .zipcode(command.zipcode())
                .city(command.city())
                .appUser(savedUser)
                .build();
        return addressRepository
                .save(savedAddress)
                .map(address -> HttpResponse
                        .<AppUser>noContent()
                        .header(HttpHeaders.LOCATION, URI.create("/users/" + address.getId()).getPath()));
    }

}