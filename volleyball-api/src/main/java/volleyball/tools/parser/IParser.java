package volleyball.tools.parser;

import volleyball.tools.eventData.IEventData;

import java.util.List;

public interface IParser {

    /**
     * parse a file and return a list of {@link IEventData} object
     *
     * @return the parsed data in a list of {@link IEventData} objects
     */
    List<IEventData> parseFile();
}
