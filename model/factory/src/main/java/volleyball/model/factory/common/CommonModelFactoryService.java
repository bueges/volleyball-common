package volleyball.model.factory.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volleyball.model.builder.common.*;
import volleyball.model.factory.ModelFactoryService;

@Service
public class CommonModelFactoryService extends ModelFactoryService {

    @Autowired
    @Override
    public void init() {
        associationBuilder = new CommonAssociationBuilder();
        seasonBuilder = new CommonSeasonBuilder();
        competitionBuilder = new CommonCompetitionBuilder();
        resultBuilder = new CommonResultBuilder();
        matchBuilder = new CommonMatchBuilder();
        clubBuilder = new CommonClubBuilder();
        teamBuilder = new CommonTeamBuilder();
    }
}
