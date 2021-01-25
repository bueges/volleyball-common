package volleyball.model.factory.sams;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import volleyball.model.factory.TestApplication;
import volleyball.importer.importerData.IImportedData;
import volleyball.model.repository.RepositoryService;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestApplication.class)
class SamsModelFactoryServiceTest {

    @Autowired
    SamsModelFactoryService modelFactoryService;

    @Autowired
    RepositoryService repositoryService;

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getCompleteImportedData")
    @DisplayName("create model objects from complete imported data")
    @Transactional
    public void testCreateModelObjectFromImportedData(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(1, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(2, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutAssociationName")
    @DisplayName("create model objects from imported data without association name")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutAssociationName(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(0, repositoryService.getAssociationList().size());
        assertEquals(0, repositoryService.getSeasonList().size());
        assertEquals(0, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(0, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutSeasonStartYear")
    @DisplayName("create model objects from imported data without season period")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutSeasonStartYear(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(0, repositoryService.getSeasonList().size());
        assertEquals(0, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(0, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutSeasonEndYear")
    @DisplayName("create model objects from imported data without season period")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutSeasonEndYear(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(0, repositoryService.getSeasonList().size());
        assertEquals(0, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(0, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutCompetitionName")
    @DisplayName("create model objects from imported data without competition name")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutCompetitionName(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(0, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(0, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutResultSetsTeam1")
    @DisplayName("create model objects from imported data without result sets team1")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutResultSetsTeam1(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(0, repositoryService.getResultList().size());
        assertEquals(1, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(2, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutResultSetsTeam2")
    @DisplayName("create model objects from imported data without result sets team2")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutResultSetsTeam2(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(0, repositoryService.getResultList().size());
        assertEquals(1, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(2, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutMatchDateTime")
    @DisplayName("create model objects from imported data without match date time")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutMatchDateTime(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(2, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutMatchNumber")
    @DisplayName("create model objects from imported data without match data")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutMatchNumber(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(2, repositoryService.getTeamList().size());
    }


    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutClubName")
    @DisplayName("create model objects from imported data without club name")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutClubName(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(0, repositoryService.getClubList().size());
        assertEquals(0, repositoryService.getTeamList().size());
    }

    @ParameterizedTest
    @MethodSource("volleyball.model.factory.TestParameter#getImportedDataWithoutTeamData")
    @DisplayName("create model objects from imported data without team data")
    @Transactional
    public void testCreateModelObjectFromImportedDataWithoutTeamData(IImportedData importedData) {
        modelFactoryService.buildAndSaveModelObjectsFromImportedData(Lists.newArrayList(importedData));

        assertEquals(1, repositoryService.getAssociationList().size());
        assertEquals(1, repositoryService.getSeasonList().size());
        assertEquals(1, repositoryService.getCompetitionList().size());
        assertEquals(1, repositoryService.getResultList().size());
        assertEquals(0, repositoryService.getMatchList().size());
        assertEquals(2, repositoryService.getClubList().size());
        assertEquals(0, repositoryService.getTeamList().size());
    }

}