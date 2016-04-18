package pl.java.scalatech.domain.inherit.mapped;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "DebitAccount")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DebitAccount extends Account {

    private static final long serialVersionUID = -8161742730954756627L;
    private BigDecimal overdraftFee;
}
