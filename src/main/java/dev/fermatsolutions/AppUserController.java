package dev.fermatsolutions;

import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;
import lombok.val;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller("/users")
@AllArgsConstructor
public class AppUserController {

    private final AppUserRepository appUserRepository;

    @Get("/{id}")
    Mono<AppUser> find(@PathVariable Long id) {
        return appUserRepository.findById(id);
    }

    @Post
    Mono<AppUser> save(@Body @Valid AppUserSaveCommand command) {
        val savedEntity = AppUser.builder()
                .firstName(command.firstName())
                .lastName(command.lastName())
                .build();
        return appUserRepository.save(savedEntity).map(v -> savedEntity);
    }

}