package pl.java.scalatech.domain.inherit.joined;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "CreditAccount")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreditAccountJoin extends AccountJoin {

    private BigDecimal creditLimit;
}