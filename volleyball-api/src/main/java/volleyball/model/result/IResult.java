package volleyball.model.result;

import volleyball.model.IModelObject;

public interface IResult extends IModelObject {

    /**
     * @return the sets of the first team
     */
    int getSetsTeam1();

    /**
     * @return the sets of the second team
     */
    int getSetsTeam2();
}
