package pl.java.scalatech.domain.inherit.mapped;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "CreditAccount")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreditAccount extends Account {

    private static final long serialVersionUID = -3038015441274321410L;
    private BigDecimal creditLimit;

}