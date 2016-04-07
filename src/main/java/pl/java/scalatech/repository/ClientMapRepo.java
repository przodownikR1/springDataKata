package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.persistenceMap.Client;

public interface ClientMapRepo extends JpaRepository<Client, Long>{

}
