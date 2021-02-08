package volleyball.tools.parser;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface IParser {

    /**
     * parse a file and return a list of {@link IParserResult} object
     *
     * @return the parsed data in a list of {@link IParserResult} objects
     */
    List<IParserResult> parseFile();
}
