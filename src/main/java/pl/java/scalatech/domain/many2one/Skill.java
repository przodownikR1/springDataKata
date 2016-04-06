package pl.java.scalatech.domain.many2one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.Person;

@Entity
@Table(name="skills")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Skill extends AbstractEntity{
    private static final long serialVersionUID = -7882492893777324229L;
    @Column(name="SKILL_NAME")
    private String name;
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Person person;


}
