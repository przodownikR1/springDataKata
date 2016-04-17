package pl.java.scalatech.repository.oneToOneBi;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.oneToOneBi.EmailMessage_BI;

public interface BiEmailMessageRepo extends JpaRepository<EmailMessage_BI, Long>{

}
