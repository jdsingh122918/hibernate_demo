package dev.fermatsolutions;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;

import javax.validation.constraints.Size;

@Introspected
public record AppUserDetailRequestCommand(@Nullable String first_name,
                                          @Nullable String last_name,
                                          @Nullable @Size(max = 5, min = 5) String zipcode) {
}
