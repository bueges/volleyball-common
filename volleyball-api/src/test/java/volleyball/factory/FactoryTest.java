package volleyball.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.TestData;
import volleyball.model.athlete.Athlete;
import volleyball.model.match.Match;
import volleyball.modelData.athleteData.AthleteData;
import volleyball.modelData.athleteData.IAthleteData;
import volleyball.repository.Repository;
import volleyball.modelData.eventData.IEventData;
import volleyball.modelData.eventData.EventData;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FactoryTest {

    @Autowired
    Repository repository;

    @Autowired
    Factory factory;

    @Test
    @DisplayName("build and save athlete object")
    public void buildAndSaveAthleteObjet(){
        IAthleteData athleteData = AthleteData.builder()
                .withAthleteName(TestData.ATHLETE_NAME)
                .withAthletePreName(TestData.ATHLETE_PRENAME)
                .withAthleteBirthday(TestData.ATHLETE_BIRTHDAY)
                .withAthleteGender(TestData.ATHLETE_GENDER)
                .build();

        Optional<Athlete> athlete = factory.buildAndSaveAthleteObject(athleteData);
        assertTrue(athlete.isPresent());
    }

    @Test
    @DisplayName("build and save match object with complete parser result")
    @Transactional
    public void buildAndSaveMatchObjectWithCompleteParserResult() {
        IEventData eventData = EventData.builder()
                .withAssociationName(TestData.ASSOCIATION_NAME)
                .withSeasonStartYear(TestData.SEASON_START_YEAR)
                .withSeasonEndYear(TestData.SEASON_END_YEAR)
                .withCompetitionName(TestData.COMPETITION_NAME)
                .withMatchNumber(TestData.MATCH_NUMBER)
                .withMatchDateTime(TestData.MATCH_DATE_TIME)
                .withClub1Name(TestData.CLUB1_NAME)
                .withTeam1Name(TestData.TEAM1_NAME)
                .withClub2Name(TestData.CLUB2_NAME)
                .withTeam2Name(TestData.TEAM2_NAME)
                .withSetsTeam1(TestData.RESULT_TEAM1_SETS)
                .withSetsTeam2(TestData.RESULT_TEAM2_SETS)
                .build();

        Optional<Match> match = factory.buildAndSaveMatchObject(eventData);
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
    @MethodSource("volleyball.TestData#getRequiredData")
    @DisplayName("build and save match object with required data")
    @Transactional
    public void buildAndSaveMatchObjectWithRequiredData(IEventData parserResult) {
        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);
        assertTrue(match.isPresent());
        assertEquals(1, repository.getMatchObjects().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getInvalidSeasonData")
    @DisplayName("build and save match object with invalid season data")
    @Transactional
    public void buildAndSaveMatchObjectWithInvalidSeasonData(IEventData parserResult) {
        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);

        assertTrue(match.isPresent());
        assertEquals(1, repository.getMatchObjects().size());
        assertEquals(0, repository.getSeasonObjects().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getInvalidResultData")
    @DisplayName("build and save match object with invalid result data")
    @Transactional
    public void buildAndSaveMatchObjectWithInvalidResultData(IEventData parserResult) {
        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);

        assertTrue(match.isPresent());
        assertEquals(1, repository.getMatchObjects().size());
        assertEquals(0, repository.getResultObjects().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.TestData#getInvalidMatchData")
    @DisplayName("build and save match object with invalid match data")
    @Transactional
    public void buildAndSaveMatchObjectWithInvalidMatchData(IEventData parserResult) {
        Optional<Match> match = factory.buildAndSaveMatchObject(parserResult);

        assertFalse(match.isPresent());
        assertEquals(0, repository.getMatchObjects().size());
    }

    @Test
    @DisplayName("build and save match object with NULL data")
    @Transactional
    public void buildAndSaveMatchObjectWithNULLData() {
        Optional<Match> match = factory.buildAndSaveMatchObject(null);

        assertFalse(match.isPresent());
        assertEquals(0, repository.getMatchObjects().size());
    }
}
