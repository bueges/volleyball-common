package volleyball.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTestUtils {

    public static void checkRepositorySize(JpaRepository repository, int expectedSize) {
        assertEquals(expectedSize, repository.findAll().size());
    }
}
