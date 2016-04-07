package pl.java.scalatech.domain.bidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity(name = "Person")
@NoArgsConstructor
@Data
public class PersonBi extends AbstractEntity{

    private static final long serialVersionUID = -8702910393576830509L;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneBi> phones = new ArrayList<>();

    public PersonBi(Long id) {
        this.id = id;
    }

    public void addPhone(PhoneBi phone) {
        phones.add( phone );
        phone.setPerson( this );
    }

    public void removePhone(PhoneBi phone) {
        phones.remove( phone );
        phone.setPerson( null );
    }
}

