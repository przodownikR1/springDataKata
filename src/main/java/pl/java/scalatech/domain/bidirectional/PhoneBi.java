package pl.java.scalatech.domain.bidirectional;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity(name = "PhoneBi")
@Data
@NoArgsConstructor
public class PhoneBi extends AbstractEntity{

    private static final long serialVersionUID = 1661775464555432081L;

    @NaturalId
    @Column(unique = true)
    private String number;

    @ManyToOne
    private PersonBi person;

    public PhoneBi(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        PhoneBi phone = (PhoneBi) o;
        return Objects.equals( number, phone.number );
    }

    @Override
    public int hashCode() {
        return Objects.hash( number );
    }
}

