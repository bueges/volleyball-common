package volleyball.common.model.member;

import volleyball.common.model.IModelObject;

import java.time.LocalDate;

public interface IMember extends IModelObject {

    String getName();

    String getPreName();

    LocalDate getBirthday();
}
