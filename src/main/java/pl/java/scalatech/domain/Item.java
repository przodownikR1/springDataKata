package pl.java.scalatech.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Data;
import pl.java.scalatech.domain.audit.Audit;

@Entity
@Data
public class Item extends Audit {

    private String name;
    private BigDecimal price;


}
