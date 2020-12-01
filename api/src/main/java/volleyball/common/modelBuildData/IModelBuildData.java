package volleyball.common.modelBuildData;

import java.util.Optional;

public interface IModelBuildData {

    Optional<String> getTeam1Name();

    Optional<String> getTeam2Name();

    Optional<String> getAssociationName();

    Optional<String> getSeasonPeriod();

    Optional<String> getCompetitionName();

    Optional<String> getResultTeam1Sets();

    Optional<String> getResultTeam2Sets();

    Optional<String> getMatchDateTime();

    Optional<String> getMatchNumber();
}
