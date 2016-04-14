package pl.java.scalatech.domain.override_attr;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {

    private String firstName;

    private String middleName;

    private String lastName;

}
