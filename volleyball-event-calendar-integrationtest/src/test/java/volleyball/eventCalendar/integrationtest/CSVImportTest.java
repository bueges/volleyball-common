package volleyball.eventCalendar.integrationtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import volleyball.eventCalendar.factory.samsFactory.SamsFactory;
import volleyball.eventCalendar.tools.csvparser.CSVParser;
import volleyball.model.match.Match;
import volleyball.repository.Repository;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CSVImportTest {

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
        samsFactory.parseDataAndSaveObjects(csvParser);

        List<Match> matchList = repository.getMatchObjects();
        assertNotNull(matchList);
        assertEquals(1, matchList.size());
        Match match = matchList.get(0);
        assertEquals(0, match.getResult().get().getSetsTeam1());
        assertEquals(0, match.getResult().get().getSetsTeam2());

        // import playing schedule with result
        csvParser = new CSVParser(associationName, Paths.get("src", "test", "resources", "csvParser", "PlayingScheduleWithResult.csv"));
        samsFactory.parseDataAndSaveObjects(csvParser);

        matchList = repository.getMatchObjects();
        assertNotNull(matchList);
        assertEquals(1, matchList.size());
        match = matchList.get(0);
        assertEquals(3, match.getResult().get().getSetsTeam1());
        assertEquals(0, match.getResult().get().getSetsTeam2());
    }
}
