package volleyball.factory;

import volleyball.model.match.Match;
import volleyball.model.member.Member;
import volleyball.tools.parser.IParserResult;

import java.util.Optional;
import java.util.function.Predicate;

public interface IModelFactory {

    /**
     * build and save a {@link Match} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Match} object or an empty object
     */
    Optional<Match> buildAndSaveMatchObject(IParserResult parserResult);

    /**
     * build and save a {@link Member} object
     *
     * @param parserResult - the parsed data
     * @return the saved {@link Member} object or an empty object
     */
    Optional<Member> buildAndSaveMemberObject(IParserResult parserResult);
}
