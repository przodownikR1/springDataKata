package pl.java.scalatech.repository.overrideAttr;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.override_attr.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
