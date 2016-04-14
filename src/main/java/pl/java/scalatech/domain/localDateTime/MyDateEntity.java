package pl.java.scalatech.domain.localDateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyDateEntity extends AbstractEntity{

    private static final long serialVersionUID = 7514429149616834064L;

    @Column(name="MY_DATE")
	private LocalDate date;

	@Column(name="MY_DATE_TIME")
	private LocalDateTime dateTime;

	@Column(name="MY_DURATION")
	private Duration duration;


}