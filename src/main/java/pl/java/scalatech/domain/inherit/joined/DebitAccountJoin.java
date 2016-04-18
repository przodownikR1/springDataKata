package pl.java.scalatech.domain.inherit.joined;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "DebitAccount")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public  class DebitAccountJoin extends AccountJoin {

    private BigDecimal overdraftFee;
}
