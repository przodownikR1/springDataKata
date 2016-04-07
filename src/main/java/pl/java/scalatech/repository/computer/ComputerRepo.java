package pl.java.scalatech.repository.computer;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.collectionElement.Computer;

public interface ComputerRepo extends JpaRepository<Computer,Long>{

}
