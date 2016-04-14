package pl.java.scalatech.overrideAtt;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.repository.overrideAttr.ContactRepository;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class OverrideAttrTest {
    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void shouldWiredContact(){
        Assertions.assertThat(contactRepository).isNotNull();
    }

}
