package pl.java.scalatech.many2one;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.domain.many2one.GroupPeople;
import pl.java.scalatech.repository.PersonRepository;
import pl.java.scalatech.repository.many2one.GroupPeopleRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class Many2OneJoinColumnTest {
    private Person p1;
    private GroupPeople gp;
    @Before
   public  void init(){
        p1 = Person.builder().firstname("slawek").email("slawek@tlen.pl").birthDay(ZonedDateTime.now()).build();
        gp = new GroupPeople("javaForum", p1);
    }

    @Autowired
    private GroupPeopleRepo groupPeopleRepo;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldSave(){
        groupPeopleRepo.save(gp);
        log.info("gp : {}",groupPeopleRepo.findAll());
    }

   @Test
    public void shouldLoadByPersonSite(){
        groupPeopleRepo.save(gp);
        log.info("person site : {}",personRepository.findAll());
    }

    @Test
    public void shouldInject(){
        assertThat(groupPeopleRepo).isNotNull();
    }
}
