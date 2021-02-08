package volleyball.model.member;

import volleyball.model.IModelObject;

import java.time.LocalDate;

public interface IMember extends IModelObject {

    /**
     * @return the member name
     */
    String getName();

    /**
     * @return the member preName
     */
    String getPreName();

    /**
     * @return the member birthday
     */
    LocalDate getBirthday();

    /**
     * @return the member gender
     */
    Gender getGender();
}
