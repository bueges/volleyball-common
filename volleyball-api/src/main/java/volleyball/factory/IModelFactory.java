package volleyball.factory;

import volleyball.model.match.Match;
import volleyball.model.athlete.Athlete;
import volleyball.modelData.athleteData.IAthleteData;
import volleyball.modelData.eventData.IEventData;
import volleyball.tools.parser.IParser;

import java.util.List;
import java.util.Optional;

public interface IModelFactory {

    List<Match> parseDataAndSaveObjects(IParser parser);

    /**
     * build and save a {@link Match} object
     *
     * @param eventData - the parsed data
     * @return the saved {@link Match} object or an empty object
     */
    Optional<? extends Match> buildAndSaveMatchObject(IEventData eventData);

    /**
     * build and save a {@link Athlete} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Athlete} object or an empty object
     */
    Optional<? extends Athlete> buildAndSaveAthleteObject(IAthleteData athleteData);
}
