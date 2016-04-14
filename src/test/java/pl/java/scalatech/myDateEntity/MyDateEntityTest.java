package pl.java.scalatech.myDateEntity;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.localDateTime.MyDateEntity;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
@Transactional
public class MyDateEntityTest {

    @Autowired
    private EntityManager em;

    @Test
    public void shouldInjectEm(){
        Assertions.assertThat(em).isNotNull();
    }

    @Test
    public void shouldDateLocalTimeSave(){
          MyDateEntity entity = new MyDateEntity(LocalDate.of(2016, 4, 14),LocalDateTime.now(),Duration.ofDays(1));
          em.persist(entity);
          log.info("{}",em.find(MyDateEntity.class, 1l));
    }
    @Test
    public void shouldTypedQueryWork(){
        LocalDate date = LocalDate.of(2016, 4, 15);
        TypedQuery<MyDateEntity> query = em.createQuery("SELECT e FROM MyDateEntity e WHERE date BETWEEN :start AND :end", MyDateEntity.class);
        query.setParameter("start", date.minusDays(1));
        query.setParameter("end", date.plusDays(1));
        MyDateEntity e = query.getSingleResult();
        assertThat(e).isNotNull();
    }

}
