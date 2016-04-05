package pl.java.scalatech.oneToOne;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.oneToOne.Email;
import pl.java.scalatech.domain.oneToOne.EmailMessage;
import pl.java.scalatech.repository.oneToOne.EmailMessageRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class OneToOneTest extends TestJpaConfig{

    @Autowired
    private EmailMessageRepo emailMessageRepo;

    @Test
    public void shouldRepositoryAutowired(){
        Email email = Email.builder().from("przodownik").to("slawek").time(LocalDateTime.now()).build();
        EmailMessage em = EmailMessage.builder().content("this is text").email(email).build();
        emailMessageRepo.save(em);
        log.info("{}",emailMessageRepo.findAll());
    }

    @Test
    public void shouldSave(){
        assertThat(emailMessageRepo).isNotNull();
    }

}
