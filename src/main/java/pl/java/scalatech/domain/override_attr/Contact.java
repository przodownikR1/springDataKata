package pl.java.scalatech.domain.override_attr;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact extends AbstractEntity{

    private static final long serialVersionUID = 8647206382312922870L;

    @Embedded
    private Name name;


    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "line1", column = @Column( name = "home_address_line1" )),
        @AttributeOverride(name = "line2",column = @Column( name = "home_address_line2" )),
        @AttributeOverride(name = "zipCode.postalCode",column = @Column( name = "home_address_postal_cd" )),
        @AttributeOverride(name = "zipCode.plus4",column = @Column( name = "home_address_postal_plus4" ))
        })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "line1",column = @Column( name = "mailing_address_line1" )),
        @AttributeOverride(name = "line2",column = @Column( name = "mailing_address_line2" )),
        @AttributeOverride(name = "zipCode.postalCode",column = @Column( name = "mailing_address_postal_cd" )),
        @AttributeOverride(name = "zipCode.plus4",column = @Column( name = "mailing_address_postal_plus4" ))
    })
    private Address mailingAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "line1",column = @Column( name = "work_address_line1" )),
        @AttributeOverride(name = "line2",column = @Column( name = "work_address_line2" )),
        @AttributeOverride(name = "zipCode.postalCode",column = @Column( name = "work_address_postal_cd" )),
        @AttributeOverride(name = "zipCode.plus4",column = @Column( name = "work_address_postal_plus4" ))
        })
    private Address workAddress;


}

