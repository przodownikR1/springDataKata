package pl.java.scalatech.repository.oneToOneBi;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.oneToOneBi.Email_BI;

public interface BiEmailRepo extends JpaRepository<Email_BI, Long>{

}
