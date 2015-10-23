package pl.java.scalatech;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonRepository;
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestJpaConfig.class)
public class StreamRepositoryTest
{   
    @Autowired
    private PersonRepository personRepository;
    
    @Test
    public void shouldRetrievePerson(){
        personRepository.save(Person.builder().email("przodownikR1@gmail.com").firstname("przodownik").birthDay(ZonedDateTime.now()).modify(LocalDate.now()).build());
        personRepository.save(Person.builder().email("kalinaR1@gmail.com").firstname("kalina").birthDay(ZonedDateTime.now()).modify(LocalDate.now()).build());
        personRepository.save(Person.builder().email("aga@gmail.com").firstname("aga").birthDay(ZonedDateTime.now()).modify(LocalDate.now()).build());
        personRepository.save(Person.builder().email("bak@gmail.com").firstname("bak").birthDay(ZonedDateTime.now()).modify(LocalDate.now()).build());
        

        
      try (Stream<Person> stream = personRepository.all()) {
            stream.forEach(test -> log.info("{}", test.getFirstname()));
        }
    }
    
}
