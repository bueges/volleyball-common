package volleyball.common.factory;

import volleyball.common.model.association.IAssociation;
import volleyball.common.model.club.IClub;
import volleyball.common.model.competition.ICompetition;
import volleyball.common.model.match.IMatch;
import volleyball.common.model.result.IResult;
import volleyball.common.model.season.ISeason;
import volleyball.common.model.team.ITeam;
import volleyball.common.modelBuildData.IModelBuildData;

import java.util.Optional;

public interface IFactory {

    Optional<IClub> buildAndSaveClub1FromModelData(IModelBuildData modelData);

    Optional<ITeam> buildAndSaveTeam1FromModelData(IModelBuildData modelData);

    Optional<IClub> buildAndSaveClub2FromModelData(IModelBuildData modelData);

    Optional<ITeam> buildAndSaveTeam2FromModelData(IModelBuildData modelData);

    Optional<IAssociation> buildAndSaveAssociationFromModelData(IModelBuildData modelData);

    Optional<ISeason> buildAndSaveSeasonFromModelData(IModelBuildData modelData);

    Optional<ICompetition> buildAndSaveCompetitionFromModelData(IModelBuildData modelData);

    Optional<IResult> buildAndSaveResultFromModelData(IModelBuildData modelData);

    Optional<IMatch> buildAndSaveMatchFromModelData(IModelBuildData modelData);
}
