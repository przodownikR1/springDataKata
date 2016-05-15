package pl.java.scalatech.repository.audit;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.audit.Option;

public interface OptionRepository extends JpaRepository<Option, Long>{

}
