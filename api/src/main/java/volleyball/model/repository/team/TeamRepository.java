package volleyball.model.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.builder.team.Team;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    default Team saveObject(Team team) {
        Optional<Team> dbObjet = findAll().stream().filter(o -> o.equals(team)).findFirst();

        if (!dbObjet.isPresent()) {
            save(team);
            return team;
        } else {
            return dbObjet.get();
        }
    }
}


