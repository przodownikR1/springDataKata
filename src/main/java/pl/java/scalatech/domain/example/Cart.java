package pl.java.scalatech.domain.example;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString
public class Cart extends AbstractEntity{

    private String name;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="cartId")
    private List<Product> products;
    
}
