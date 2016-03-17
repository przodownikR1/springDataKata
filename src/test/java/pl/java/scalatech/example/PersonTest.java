package pl.java.scalatech.example;

import java.time.ZonedDateTime;

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
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;
    @Test
    public void test(){
        personRepository.save(Person.builder().email("przodownikR1@gmail.com").firstname("slawek").birthDay(ZonedDateTime.now()).build());  
    }
}
