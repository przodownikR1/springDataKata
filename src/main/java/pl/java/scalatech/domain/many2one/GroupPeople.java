package pl.java.scalatech.domain.many2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.Person;

@Entity
@Table(name="groupPeople")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GroupPeople extends AbstractEntity {

    private static final long serialVersionUID = -4698080659336703752L;

    private String organization;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    private Person person;

}
