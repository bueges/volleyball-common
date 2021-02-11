package volleyball.eventCalendar.importer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import volleyball.model.association.Association;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.repository.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImporterTest {

    @Autowired
    Importer importer;

    @Autowired
    Repository repository;

    @Test
    @DisplayName("import event data from url")
    @Transactional
    public void importEventDataFromURL() {
        importer.importData();

        // check associations
        List<Association> associationList = repository.getAssociationObjects();
        assertNotNull(associationList);
        assertEquals(1, associationList.size());

        // check competitions
        List<Competition> competitionList = repository.getCompetitionObjects();
        assertNotNull(competitionList);
        assertEquals(1, competitionList.size());

        // check matches
        List<Match> matchList = repository.getMatchObjects();
        assertNotNull(matchList);
        assertTrue(matchList.size() > 0);

        // check clubs
        List<Club> clubList = repository.getClubObjects();
        assertNotNull(clubList);
        assertTrue(clubList.size() > 0);

        // check teams
        List<Team> teamList = repository.getTeamObjects();
        assertNotNull(teamList);
        assertTrue(teamList.size() > 0);
    }
}