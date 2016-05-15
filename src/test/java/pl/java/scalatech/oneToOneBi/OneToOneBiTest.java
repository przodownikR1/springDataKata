package pl.java.scalatech.oneToOneBi;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.oneToOneBi.EmailMessage_BI;
import pl.java.scalatech.domain.oneToOneBi.Email_BI;
import pl.java.scalatech.repository.oneToOneBi.BiEmailMessageRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class OneToOneBiTest extends TestJpaConfig{

    @Autowired
    private BiEmailMessageRepo emailMessageRepo;

    @Test
    public void shouldRepositoryAutowired(){
        Email_BI email = Email_BI.builder().from("przodownik").to("slawek").time(LocalDateTime.now()).build();
        EmailMessage_BI em = EmailMessage_BI.builder().content("this is text").email(email).build();
        emailMessageRepo.save(em);
        log.info("emailMessage : {}",emailMessageRepo.findOne(1l));
        log.info("email : {}",emailMessageRepo.findOne(1l).getEmail());
    }

    @Test
    public void shouldSave(){
        assertThat(emailMessageRepo).isNotNull();
    }

}
