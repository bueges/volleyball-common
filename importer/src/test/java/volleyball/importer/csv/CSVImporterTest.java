package volleyball.importer.csv;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import volleyball.TestConstants;
import volleyball.importer.importerData.IImportedData;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static volleyball.TestConstants.ASSOCIATION_NAME;

public class CSVImporterTest {

    @Test
    @DisplayName("import empty playing schedule")
    public void testImporterEmptyPlayingSchedule() {
        Path csvFilePath = Paths.get("src", "test", "resources", "csv", "EmptyPlayingSchedule.csv");
        CSVImporter csvImporter = new CSVImporter(csvFilePath, ASSOCIATION_NAME);
        List<IImportedData> dataList = csvImporter.importData();

        Assert.assertEquals(0, dataList.size());
    }

    @Test
    @DisplayName("import playing schedule ")
    public void testImportPlyingSchedule() {
        Path csvFilePath = Paths.get("src", "test", "resources", "csv", "PlayingSchedule.csv");
        CSVImporter csvImporter = new CSVImporter(csvFilePath, ASSOCIATION_NAME);
        List<IImportedData> dataList = csvImporter.importData();

        Assert.assertEquals(1, dataList.size());
        IImportedData importedData = dataList.get(0);

        Assert.assertTrue(importedData.getClub1Name().isPresent());
        Assert.assertEquals("1. VC Parchim", importedData.getClub1Name().get());
        Assert.assertTrue(importedData.getTeam1Name().isPresent());
        Assert.assertEquals("1. VC Parchim", importedData.getTeam1Name().get());

        Assert.assertTrue(importedData.getClub2Name().isPresent());
        Assert.assertEquals("VT Hamburg 1990", importedData.getClub2Name().get());
        Assert.assertTrue(importedData.getTeam2Name().isPresent());
        Assert.assertEquals("VT Hamburg 1990 2", importedData.getTeam2Name().get());

        Assert.assertTrue(importedData.getAssociationName().isPresent());
        Assert.assertEquals("association", importedData.getAssociationName().get());

        Assert.assertTrue(importedData.getSeasonStartYear().isPresent());
        Assert.assertEquals(Integer.valueOf(2020), importedData.getSeasonStartYear().get());
        Assert.assertTrue(importedData.getSeasonEndYear().isPresent());
        Assert.assertEquals(Integer.valueOf(2021), importedData.getSeasonEndYear().get());

        Assert.assertTrue(importedData.getCompetitionName().isPresent());
        Assert.assertEquals("Regionalliga Nord 1 Frauen", importedData.getCompetitionName().get());

        Assert.assertTrue(importedData.getMatchNumber().isPresent());
        Assert.assertEquals("1201", importedData.getMatchNumber().get());
        Assert.assertTrue(importedData.getMatchDateTime().isPresent());
        Assert.assertEquals(LocalDateTime.of(2020, 10, 4, 17, 0), importedData.getMatchDateTime().get());

        Assert.assertTrue(importedData.getSetsTeam1().isPresent());
        Assert.assertEquals(Integer.valueOf(3), importedData.getSetsTeam1().get());
        Assert.assertTrue(importedData.getSetsTeam2().isPresent());
        Assert.assertEquals(Integer.valueOf(0), importedData.getSetsTeam2().get());
    }
}