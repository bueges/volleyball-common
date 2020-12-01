package volleyball.model.repository.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.common.model.club.Club;

import java.util.Optional;

@Repository
public interface IClubRepository extends JpaRepository<Club, Integer> {

    default Club saveObject(Club club) {
        Optional<Club> dbObjet = findAll().stream().filter(o -> o.equals(club)).findFirst();

        if (!dbObjet.isPresent()) {
            save(club);
            return club;
        } else {
            return dbObjet.get();
        }
    }
}


