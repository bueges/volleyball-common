package volleyball.model.event;

import volleyball.model.IModelObject;
import volleyball.model.match.IMatch;

public interface IEvent extends IModelObject {

    /**
     * @return the {@link IMatch} reference
     */
    IMatch getMatch();
}
