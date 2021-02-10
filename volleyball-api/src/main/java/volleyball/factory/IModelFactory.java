package volleyball.factory;

import volleyball.model.match.Match;
import volleyball.model.athlete.Athlete;
import volleyball.tools.parser.IParserResult;

import java.util.Optional;

public interface IModelFactory {

    /**
     * build and save a {@link Match} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Match} object or an empty object
     */
    Optional<Match> buildAndSaveMatchObject(IParserResult parserResult);

    /**
     * build and save a {@link Athlete} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Athlete} object or an empty object
     */
    Optional<Athlete> buildAndSaveMemberObject(IParserResult parserResult);
}
