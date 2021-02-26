package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Club;
import volleyball.eventcalendar.repository.ClubRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ClubFactory {

    private ClubRepository repository;

    public Club createClub(String clubName) {
        Optional<Club> dbObject = repository
                .findClubByName(clubName);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Club.builder()
                    .withName(clubName)
                    .build());
        }
    }
}
