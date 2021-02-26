package volleyball.eventcalendar.factory;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import volleyball.eventcalendar.entity.Association;
import volleyball.eventcalendar.entity.Season;
import volleyball.eventcalendar.repository.AssociationRepository;

import java.util.Optional;

@AllArgsConstructor
@Component
public class AssociationFactory {

    private AssociationRepository repository;

    public Association createAssociation(String associationName) {
        Optional<Association> dbObject = repository
                .findAssociationByName(associationName);

        if (dbObject.isPresent()) {
            return dbObject.get();
        } else {
            return repository.save(Association.builder()
                    .withName(associationName)
                    .build());
        }
    }
}
