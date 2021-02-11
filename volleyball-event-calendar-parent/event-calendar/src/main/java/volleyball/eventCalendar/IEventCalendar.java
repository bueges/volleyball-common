package volleyball.eventCalendar;

import volleyball.model.IModelObject;
import volleyball.model.match.Match;

import java.util.List;

public interface IEventCalendar {

    /**
     * @return a list with {@link Match} objects
     */
    List<Match> getCalendar();
}
