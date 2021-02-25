package volleyball.eventCalendar.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class DefaultEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    private Date created = new Date();
}
