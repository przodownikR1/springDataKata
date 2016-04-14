package pl.java.scalatech.secondary;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.secondary.MySecondaryTable;
import pl.java.scalatech.repository.secondary.SecondaryRepository;
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class SecondaryTableTest {

    @Autowired
    private SecondaryRepository repo;


    @Test
    public void shouldAutowired(){
        assertThat(repo).isNotNull();
    }
    @Test
    public void shouldSave(){
        MySecondaryTable mst = new MySecondaryTable("slawek","yamaha");


        repo.save(mst);
        log.info("{}",repo.findAll());
        Assertions.assertThat(repo.count()).isEqualTo(1l);
    }

}




