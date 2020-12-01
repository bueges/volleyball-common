package volleyball.common.importer;

import volleyball.common.modelBuildData.IModelBuildData;

import java.util.List;

public interface IImporter {

    List<IModelBuildData> importModelData();
}
