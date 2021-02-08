package volleyball.manager.factory.samsFactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.model.match.Match;
import volleyball.repository.Repository;
import volleyball.tools.parser.IParserResult;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class SamsFactoryTest {

    @Autowired
    SamsFactory factory;

    @Autowired
    Repository repository;

    @ParameterizedTest
    @MethodSource("volleyball.TestParameter#getValidMatchData")
    @DisplayName("build and save match object with valid match data")
    @Transactional
    public void buildAndSaveMatchObjectWithValidParserResult(IParserResult parserResult) {
        assertNotNull(factory);

        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);
        assertTrue(match.isPresent());

        assertEquals(1, repository.getMatchObjects().size());
        assertEquals(1, repository.getResultObjects().size());
        assertEquals(2, repository.getClubObjects().size());
        assertEquals(2, repository.getTeamObjects().size());
        assertEquals(1, repository.getCompetitionObjects().size());
        assertEquals(1, repository.getSeasonObjects().size());
        assertEquals(1, repository.getAssociationObjects().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestParameter#getInvalidMatchData")
    @DisplayName("build and save match object with invalid match data")
    @Transactional
    public void buildAndSaveMatchObjectWithInvalidParserResult(IParserResult parserResult) {
        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);
        assertFalse(match.isPresent());

        assertEquals(0, repository.getMatchObjects().size());
        assertEquals(0, repository.getResultObjects().size());
        assertEquals(0, repository.getClubObjects().size());
        assertEquals(0, repository.getTeamObjects().size());
        assertEquals(0, repository.getCompetitionObjects().size());
        assertEquals(0, repository.getSeasonObjects().size());
        assertEquals(0, repository.getAssociationObjects().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestParameter#getInvalidResultData")
    @DisplayName("build and save match object with invalid result data")
    @Transactional
    public void buildAndSaveMatchObjectWithInvalidResultData(IParserResult parserResult) {
        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);
        assertTrue(match.isPresent());

        assertEquals(1, repository.getMatchObjects().size());
        assertEquals(0, repository.getResultObjects().size());
        assertEquals(2, repository.getClubObjects().size());
        assertEquals(2, repository.getTeamObjects().size());
        assertEquals(1, repository.getCompetitionObjects().size());
        assertEquals(1, repository.getSeasonObjects().size());
        assertEquals(1, repository.getAssociationObjects().size());
    }

}