package dev.fermatsolutions;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@MicronautTest
public class BaseDatabaseTest {

    @Property(name = "datasources.default.url")
    String url;

    @Property(name = "datasources.default.username")
    String username;

    @Property(name = "datasources.default.password")
    String password;

    @BeforeEach
    void initiateMigration() {
        Flyway.configure()
                .locations(Location.FILESYSTEM_PREFIX + "db_migrations")
                .dataSource(url, username, password)
                .load()
                .migrate();
    }

    @AfterEach
    void dropMigration() {
        Flyway.configure()
                .locations(Location.FILESYSTEM_PREFIX + "db_migrations")
                .cleanDisabled(false)
                .dataSource(url, username, password)
                .load()
                .clean();
    }
}