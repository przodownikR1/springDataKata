package pl.java.scalatech.oneToOneBi;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.oneToOneBi.EmailMessage_BI;
import pl.java.scalatech.domain.oneToOneBi.Email_BI;
import pl.java.scalatech.repository.oneToOneBi.BiEmailMessageRepo;
import pl.java.scalatech.repository.oneToOneBi.BiEmailRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
@Transactional
public class OneToOneBiTest extends TestJpaConfig{

    @Autowired
    private BiEmailMessageRepo emailMessageRepo;

    @Autowired
    private BiEmailRepo emailRepo;

    @Test
    @Ignore //TODO??
    public void shouldMessageSaveAutowired(){
        Email_BI email = Email_BI.builder().from("przodownik").to("slawek").time(LocalDateTime.now()).build();
        EmailMessage_BI em = EmailMessage_BI.builder().content("this is text").build();
        em.setEmail(email);
        emailMessageRepo.save(em);
        log.info("emailMessage : {}",emailMessageRepo.findOne(1l));
        log.info("email : {}",emailMessageRepo.findOne(1l).getEmail());
    }

    @Test
    @Ignore //TODO??
    public void shouldEmailSaveAutowired(){
        Email_BI email = Email_BI.builder().from("przodownik").to("slawek").time(LocalDateTime.now()).build();
        EmailMessage_BI em = EmailMessage_BI.builder().content("this is text").build();
        email.setEmail(em);
        emailRepo.save(email);

        log.info("email : {}",emailRepo.findOne(1l));
        log.info("emailMessage : {}",emailRepo.findOne(1l).getEmail());
    }

    @Test
    public void shouldSave(){
        assertThat(emailMessageRepo).isNotNull();
    }

}
