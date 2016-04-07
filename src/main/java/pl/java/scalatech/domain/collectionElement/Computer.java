package pl.java.scalatech.domain.collectionElement;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

/**
 * @author Sławomir Borowiec
 * Module name : springDataKata
 * Creating time :  7 kwi 2016 08:22:53

 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Computer extends AbstractEntity{

    private static final long serialVersionUID = 1814912775302352966L;

    private String name;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "interfaces")
    private Set<String> interfaces;

}
