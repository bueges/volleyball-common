package volleyball.eventCalendar.integrationtest;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import volleyball.TestData;
import volleyball.eventCalendar.factory.samsFactory.SamsFactory;
import volleyball.eventCalendar.service.EventCalendarController;
import volleyball.eventCalendar.service.EventCalendarService;
import volleyball.model.association.Association;
import volleyball.model.athlete.Athlete;
import volleyball.model.club.Club;
import volleyball.model.competition.Competition;
import volleyball.model.event.Event;
import volleyball.model.match.Match;
import volleyball.model.team.Team;
import volleyball.modelData.athleteData.AthleteData;
import volleyball.modelData.athleteData.IAthleteData;
import volleyball.repository.Repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static volleyball.TestData.*;

@SpringBootTest
@Slf4j
public class EventCalendarControllerTest {

    @Autowired
    EventCalendarController controller;

    @Autowired
    Repository repository;

    @Autowired
    SamsFactory samsFactory;

    @Test
    @DisplayName("download and parse data from different csv sources")
    @Transactional
    public void downloadAndParseDataFromDifferentCSVSources() {
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

    @Test
    @DisplayName("get athlete calendar")
    @Transactional
    public void getAthleteCalendar() {
        IAthleteData athleteData = AthleteData.builder()
                .withAthleteName(TestData.ATHLETE_NAME)
                .withAthletePreName(TestData.ATHLETE_PRENAME)
                .withAthleteBirthday(TestData.ATHLETE_BIRTHDAY)
                .withAthleteGender(TestData.ATHLETE_GENDER)
                .build();
        Athlete athlete = samsFactory.buildAndSaveAthleteObject(athleteData).get();

        Team team = repository.getTeamObjects().get(0);
        log.info("add {} to {}", athlete, team.getName());
        team.setAthleteList(Lists.newArrayList(athlete));
        Optional<Team> savedTeam = repository.saveTeamObject(team);

        Team team2 = repository.getTeamObjects().get(10);
        log.info("add {} to {}", athlete, team2.getName());
        team2.setAthleteList(Lists.newArrayList(athlete));
        Optional<Team> savedTeam2 = repository.saveTeamObject(team2);

        List<Event> eventList = controller.getAthleteCalendar(athlete);
        assertNotNull(eventList);

        assertTrue(eventList.size() > 0);
        eventList.forEach(e -> System.out.println(e.getMatch().getTeam1().getName() + " vs. " + e.getMatch().getTeam2().getName()));
    }
}
