package dev.fermatsolutions;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;

import javax.validation.constraints.NotNull;

@Introspected
public record AppUserSaveCommand(@NotNull String firstName,
                                 @Nullable String lastName,
                                 @NotNull String zipcode,
                                 @Nullable String city) {

}