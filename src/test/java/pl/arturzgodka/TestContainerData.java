package pl.arturzgodka;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TestContainerData {

    @Container
    private static PostgreSQLContainer<?> postgreSqlContainer = new PostgreSQLContainer<>( //tworzenie kontenera
            "postgres:16"/*"postgres:16-alpine"*/)
            .withDatabaseName("postgresTestContainer")
            .withUsername("postgresTestContainer")
            .withPassword("admin");


    //przekazanie wartosci do Springa aby wiedzial z czym ma sie laczyc. To jest tylko konfiguracja springowa. Mozna ja ustawic tez w application properties.
    //stworzyc application-test properties plik i tam miec te dane dla hibernate pod testy containers.
    //dane sa pobierane z kontenera przez postgresSqlContainer i przekazywane sping bootowi aby wiedzial z czym ma sie laczyc.
    @DynamicPropertySource
    public static void containerConfig(DynamicPropertyRegistry registry) { //aby nie meczyc sie juz z application properties
        registry.add("spring.datasource.url", postgreSqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSqlContainer::getUsername);
        registry.add("spring.datasource.password", postgreSqlContainer::getPassword);
    }
}
