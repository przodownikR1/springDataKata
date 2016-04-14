package pl.java.scalatech.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.secondary.MySecondaryTable;

public interface SecondaryRepository extends JpaRepository<MySecondaryTable, Long>{

}
