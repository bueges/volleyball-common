package volleyball.model.builder.association;

import lombok.*;
import volleyball.model.builder.IModelObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Entity
public class Association implements IModelObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Integer id;

    @Getter
    private String name;

    /**
     * constructor
     *
     * @param name the association name
     */
    protected Association(@NonNull String name) {
        this.name = name;
    }
}
