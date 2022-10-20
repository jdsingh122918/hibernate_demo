package dev.fermatsolutions;

import io.micronaut.core.annotation.Nullable;

import java.util.List;

public record AppUserDetailRespond(@Nullable String firstName,
                                   @Nullable String lastName,
                                   @Nullable List<Address> addresses) {
}
