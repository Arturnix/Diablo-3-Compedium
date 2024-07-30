package pl.arturzgodka;

import org.junit.Before;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.databaseutils.UserSessionFactoryTest;

@Testcontainers
public class TestContainerData {

    static DockerImageName postgres = DockerImageName.parse("postgres:16");

    @Container
    private static PostgreSQLContainer postgreSqlContainer = (PostgreSQLContainer) new PostgreSQLContainer(postgres)
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("admin")
            .withReuse(true);

    @Before
    public void testInitialization() {
        int mappedPort = postgreSqlContainer.getMappedPort(5432);
        UserDao userDaoTest = new UserDao(UserSessionFactoryTest.getCustomUserSessionFactoryTest(mappedPort));
        System.out.println(mappedPort);
    }
}
