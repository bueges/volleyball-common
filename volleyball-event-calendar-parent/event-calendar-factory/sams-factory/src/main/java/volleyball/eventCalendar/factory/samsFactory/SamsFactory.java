package volleyball.eventCalendar.factory.samsFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import volleyball.factory.Factory;
import volleyball.factory.IModelFactory;
import volleyball.model.match.Match;
import volleyball.repository.Repository;
import volleyball.modelData.eventData.IEventData;

import java.util.Optional;

@Component
@Slf4j
public class SamsFactory extends Factory implements IModelFactory {

    @Autowired
    Repository repository;

    @Override
    public Optional<Match> buildAndSaveMatchObject(IEventData eventData) {
        if (!isAssociationNamePresent.test(eventData)) {
            log.error("the required association name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodPresent.test(eventData)) {
            log.error("the required season period can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodAfterYear2000.test(eventData)) {
            log.error("the required season period can't be before year 2000 -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodInRightOrder.test(eventData)) {
            log.error("the required season period has a wrong order -  so return an empty object");
            return Optional.empty();
        }

        if (!isSeasonPeriodLengthRight.test(eventData)) {
            log.error("the required season period has a wrong length -  so return an empty object");
            return Optional.empty();
        }

        if (!isCompetitionNamePresent.test(eventData)) {
            log.error("the required competition name can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isFirstClubNamePresent.test(eventData)) {
            log.error("the required first club data can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isFirstTeamNamePresent.test(eventData)) {
            log.error("the required first team name data can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isSecondClubNamePresent.test(eventData)) {
            log.error("the required second club name data can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isSecondTeamNamePresent.test(eventData)) {
            log.error("the required second team name data can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isMatchDateTimePresent.test(eventData)) {
            log.error("the required match date time can't be empty -  so return an empty object");
            return Optional.empty();
        }

        if (!isMatchNumberPresent.test(eventData)) {
            log.error("the required match number can't be empty -  so return an empty object");
            return Optional.empty();
        }

        return super.buildAndSaveMatchObject(eventData);
    }
}
