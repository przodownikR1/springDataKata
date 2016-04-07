package pl.java.scalatech.domain.persistenceMap;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client extends AbstractEntity {

    private static final long serialVersionUID = 136842068520920236L;

    private String name;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "email")
    private Map<String, String> emails;
}
