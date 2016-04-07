package pl.java.scalatech.repository.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.bidirectional.PersonBi;

public interface PersonBiRepo extends JpaRepository<PersonBi, Long>{

}
