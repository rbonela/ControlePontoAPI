package dio.api.accesscontrol.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movement {
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovementId implements Serializable{
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long movementId;
        private long userId;
    }
    @EmbeddedId
    private MovementId id;
    private LocalDateTime entryDate;
    private LocalDateTime leaveDate;
    private BigDecimal timespan;
    @ManyToOne
    private Occurrence occurrence;
    @ManyToOne
    private Calendar calendar;
}
