package volleyball.repository.team;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volleyball.model.team.Team;

import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {

    default Team saveObject(@NonNull Team team) {
        // define filter
        Predicate<Team> filterByName = t -> t.getName().equals(team.getName());

        Predicate<Team> filterByClub = t -> {
            if (team.getClub().isPresent()) {
                return t.getClub().isPresent() && t.getClub().get().getId() == team.getClub().get().getId();
            } else {
                return !t.getClub().isPresent();
            }
        };

        Predicate<Team> filterByCompetition = t -> {
            if (team.getCompetition().isPresent()) {
                return t.getCompetition().isPresent() && t.getCompetition().get().getId() == team.getCompetition().get().getId();
            } else {
                return !t.getCompetition().isPresent();
            }
        };

        Optional<Team> searchResult = findAll()
                .stream()
                .filter(filterByName.and(filterByClub).and(filterByCompetition))
                .findFirst();

        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return save(team);
        }
    }
}
