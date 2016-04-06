package pl.java.scalatech.many2one;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZonedDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.domain.many2one.Skill;
import pl.java.scalatech.repository.many2one.SkillRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class Many2OneTest {

    @Autowired
    private SkillRepo skillRepo;

    @Test
    public void shouldSave(){
        Person p1 = Person.builder().firstname("slawek").email("slawek@tlen.pl").birthDay(ZonedDateTime.now()).build();
        Skill s = Skill.builder().name("java").person(p1).build();
        skillRepo.save(s);
        log.info("s : {}",s);
    }

    @Test
    public void shouldInject(){
        assertThat(skillRepo).isNotNull();
    }
}
