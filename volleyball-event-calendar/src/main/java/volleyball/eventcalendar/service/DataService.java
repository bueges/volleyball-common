package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.*;
import volleyball.eventcalendar.factory.*;
import volleyball.eventcalendar.repository.ClubRepository;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DataService {

    private AssociationFactory associationFactory;
    private SeasonFactory seasonFactory;
    private CompetitionFactory competitionFactory;
    private ClubFactory clubFactory;
    private TeamFactory teamFactory;
    private ResultFactory resultFactory;
    private MatchFactory matchFactory;

    public void init() {
        Association hvbv = associationFactory.createAssociation("HVBV");
        Season season2021 = seasonFactory.creatSeason(2020, 2021, hvbv);
        Competition verbandsliga = competitionFactory.createCompetition("Verbandsliga", season2021);
        Competition landesliga = competitionFactory.createCompetition("Landesliga", season2021);

        Club schwerinerSc = clubFactory.createClub("Schweriner SC");
        Team ssc1 = teamFactory.createTeam("SSC 1", schwerinerSc, verbandsliga);

        Club eimsbüttel = clubFactory.createClub("Eimsbüttel");
        Team evt1 = teamFactory.createTeam("ETV 1", eimsbüttel, verbandsliga);
        Team evt1_LL = teamFactory.createTeam("ETV 1", eimsbüttel, landesliga);

        Club vca = clubFactory.createClub("Allermöhe");
        Team vca1 = teamFactory.createTeam("VCA 1", vca, landesliga);
        Result result = resultFactory.createResult(3, 1);
        Result result_32= resultFactory.createResult(3, 2);

        matchFactory.createMatch(LocalDateTime.of(2020, 10, 20, 14, 30), "1234", evt1, ssc1, result);
        matchFactory.createMatch(LocalDateTime.now(), "1234", evt1_LL, vca1, result_32);
    }
}
