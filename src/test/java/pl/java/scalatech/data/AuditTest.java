package pl.java.scalatech.data;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.AuditConfig;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.audit.Option;
import pl.java.scalatech.repository.audit.OptionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class,AuditConfig.class})
@Slf4j
public class AuditTest {
    @Autowired
    private OptionRepository optionRepository;

  @Test
  public void shouldAuditWork(){
      optionRepository.save(Option.builder().value("my little test :").build());
      Assertions.assertThat(optionRepository.count()).isEqualTo(1l);
      log.info("option : {}",optionRepository.findOne(1l));
  }

}
