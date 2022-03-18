package jpabasichttps.start.spring.io.ex1hellojpa.hellojpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Period {
    //기간 period
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
