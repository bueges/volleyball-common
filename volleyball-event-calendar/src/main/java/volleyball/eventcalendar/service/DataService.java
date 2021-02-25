package volleyball.eventcalendar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.factory.MatchFactory;

@AllArgsConstructor
@Service
public class DataService {

    private MatchFactory matchFactory;

    public void init() {
        matchFactory.creatSeason(2020, 2021);
        matchFactory.creatSeason(2020, 2021);
//        Season season = Season.builder()
//                .withStartYear(2020)
//                .withEndYear(2021)
//                .build();
//        seasonRepository.save(season);
//
//        Association association = Association.builder()
//                .withName("HVBV")
//                .withSeason(season)
//                .build();
//
//        Association association2 = Association.builder()
//                .withName("HVBV2")
//                .withSeason(season)
//                .build();
//
//
//        associationRepository.save(association);
//        associationRepository.save(association2);


//        Competition competition1 = Competition.builder()
//                .withName("RegionalligaMänner")
//                .withAssociation(association)
//                .build();

//        Competition competition2 = Competition.builder()
//                .withName("RegionalligaFrauen")
//                .withAssociation(association)
//                .build();

//        Club club1 = Club.builder()
//                .withName("club1")
//                .build();
//
//        Team team1 = Team.builder()
//                .withName("Team 1")
//                .withClub(club1)
//                .withCompetition(competition1)
//                .build();
//
//        Club club2 = Club.builder()
//                .withName("club2")
//                .build();
//
//        Team team2 = Team.builder()
//                .withName("Team 2")
//                .withClub(club2)
//                .withCompetition(competition1)
//                .build();
//
//        Match match = Match.builder()
//                .withDateTime(LocalDateTime.now())
//                .withNumber("123456")
//                .withTeam1(team1)
//                .withTeam2(team2)
//                .withResult(Result.builder().build())
//                .build();
//
//        repository.save(match);
    }
}
