package pl.java.scalatech.repository.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.oneToOne.EmailMessage;

public interface EmailMessageRepo extends JpaRepository<EmailMessage, Long>{

}
