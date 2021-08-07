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
public class HourBank {

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class HourBankId implements Serializable {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long hourBankId;
        private long movementId;
        private long userId;
    }
    @EmbeddedId
    private HourBankId id;
    private LocalDateTime workedTime;
    private BigDecimal totalHours;
    private BigDecimal hourBalance;
}
