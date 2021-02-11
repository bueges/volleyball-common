package volleyball.calendar.integrationtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import volleyball.calendar.factory.samsFactory.SamsFactory;
import volleyball.calendar.importer.Importer;
import volleyball.calendar.tools.csvparser.CSVParser;
import volleyball.model.association.Association;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.repository.Repository;
import volleyball.tools.eventData.IEventData;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CSVImport {

    @Autowired
    Importer importer;

    @Autowired
    SamsFactory samsFactory;

    @Autowired
    Repository repository;

    @Test
    @DisplayName("import updated match data")
    @Transactional
    public void importUpdatedMatchData() {
        CSVParser csvParser;
        String associationName = "association";

        // import playing schedule without result
        csvParser = new CSVParser(associationName, Paths.get("src", "test", "resources", "csvParser", "PlayingSchedule.csv"));
        List<IEventData> eventDataList = csvParser.parseFile();
        eventDataList.stream().forEach(parserResult -> samsFactory.buildAndSaveMatchObject(parserResult));

        List<Match> matchList = repository.getMatchObjects();
        assertNotNull(matchList);
        assertEquals(1, matchList.size());
        Match match = matchList.get(0);
        assertEquals(0, match.getResult().get().getSetsTeam1());
        assertEquals(0, match.getResult().get().getSetsTeam2());

        // import playing schedule with result
        csvParser = new CSVParser(associationName, Paths.get("src", "test", "resources", "csvParser", "PlayingScheduleWithResult.csv"));
        eventDataList = csvParser.parseFile();
        eventDataList.stream().forEach(parserResult -> samsFactory.buildAndSaveMatchObject(parserResult));

        matchList = repository.getMatchObjects();
        assertNotNull(matchList);
        assertEquals(1, matchList.size());
        match = matchList.get(0);
        assertEquals(3, match.getResult().get().getSetsTeam1());
        assertEquals(0, match.getResult().get().getSetsTeam2());
    }

    @Test
    @DisplayName("download and parse data from different csv sources")
    @Transactional
    public void downloadAndParseDataFromDifferentCSVSources() {
        importer.importData();

        // check associations
        List<Association> associationList = repository.getAssociationObjects();
        assertNotNull(associationList);
        assertEquals(1, associationList.size());

        // check competitions
        List<Competition> competitionList = repository.getCompetitionObjects();
        assertNotNull(competitionList);
        assertEquals(2, competitionList.size());

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
