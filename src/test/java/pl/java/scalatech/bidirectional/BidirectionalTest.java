package pl.java.scalatech.bidirectional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.bidirectional.PersonBi;
import pl.java.scalatech.domain.bidirectional.PhoneBi;
import pl.java.scalatech.repository.bidirectional.PersonBiRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class BidirectionalTest {
    @Autowired
    private PersonBiRepo personBiRepo;
    @Test
    public void shouldSave(){
        PersonBi person = new PersonBi();
        PhoneBi phone1 = new PhoneBi( "123-456-7890" );
        PhoneBi phone2 = new PhoneBi( "321-654-0987" );
        person.addPhone( phone1 );
        person.addPhone( phone2 );
        personBiRepo.save(person);
        log.info("{}",personBiRepo.findAll());
    }

    @Test
    public void shouldAutowired(){
        assertThat(personBiRepo).isNotNull();
    }

}
