package volleyball.importer;

import volleyball.importer.importerData.IImportedData;

import java.util.List;

public interface IImporter {

    List<IImportedData> importData();
}
