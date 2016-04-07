package pl.java.scalatech.persistenceMap;

import static com.google.common.collect.Maps.newHashMap;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.persistenceMap.Client;
import pl.java.scalatech.repository.ClientMapRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class PersistenceMapTest {
    @Autowired
    private ClientMapRepo repo;
    @Test
    public void shouldSaveMap(){
        Map<String,String> emails = newHashMap();
        emails.put("przodownik", "przodownikR1@gmail.com");
        emails.put("slawek", "przodownik@tlen.pl");
        Client client = Client.builder().name("przodownik").emails(emails).build();
        repo.save(client);
        log.info("{}",repo.getOne(1l));
    }

    @Test
    public void shouldSave(){
        assertThat(repo).isNotNull();
    }
}
