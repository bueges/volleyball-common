package volleyball.model.factory.sams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import volleyball.model.builder.sams.*;
import volleyball.model.factory.ModelFactoryService;

@Service
public class SamsModelFactoryService extends ModelFactoryService {

    @Autowired
    @Override
    public void init() {
        associationBuilder = new SamsAssociationBuilder();
        seasonBuilder = new SamsSeasonBuilder();
        competitionBuilder = new SamsCompetitionBuilder();
        resultBuilder = new SamsResultBuilder();
        matchBuilder = new SamsMatchBuilder();
        clubBuilder = new SamsClubBuilder();
        teamBuilder = new SamsTeamBuilder();
    }
}
