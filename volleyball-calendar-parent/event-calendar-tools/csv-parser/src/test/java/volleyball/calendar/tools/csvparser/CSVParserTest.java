package volleyball.calendar.tools.csvparser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import volleyball.tools.eventData.IEventData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class CSVParserTest {

    @Test
    @DisplayName("start csv parser")
    public void startCSVParser() {
        Path csvFilePath = Paths.get("src", "test", "resources", "csvParser", "PlayingSchedule.csv");
        CSVParser csvParser = new CSVParser("TEST ASSOCIATION", csvFilePath);

        List<IEventData> eventDataList = csvParser.parseFile();
        assertNotNull(eventDataList);
        assertTrue(eventDataList.size() > 0);

        IEventData parserResult = eventDataList.get(0);
        assertEquals("TEST ASSOCIATION", parserResult.getAssociationName().get());
        assertEquals(2020, parserResult.getSeasonStartYear().get());
        assertEquals(2021, parserResult.getSeasonEndYear().get());
        assertEquals("Regionalliga Nord 1 Frauen", parserResult.getCompetitionName().get());
        assertEquals(LocalDateTime.of(2020, 10, 4, 17, 0), parserResult.getMatchDateTime().get());
        assertEquals("1201", parserResult.getMatchNumber().get());
        assertEquals("1. VC Parchim", parserResult.getClub1Name().get());
        assertEquals("1. VC Parchim", parserResult.getTeam1Name().get());
        assertEquals("VT Hamburg 1990", parserResult.getClub2Name().get());
        assertEquals("VT Hamburg 1990 2", parserResult.getTeam2Name().get());
        assertEquals(3, parserResult.getSetsTeam1().get());
        assertEquals(0, parserResult.getSetsTeam2().get());
    }
}