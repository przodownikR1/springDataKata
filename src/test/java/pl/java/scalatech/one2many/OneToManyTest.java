package pl.java.scalatech.one2many;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.Item;
import pl.java.scalatech.domain.one2many.Bucket;
import pl.java.scalatech.repository.one2many.BucketRepo;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class OneToManyTest {
    @Autowired
    private BucketRepo bucketRepo;

    @Test
    public void shouldSaveAndRetrieve(){
        Item itemOne = Item.builder().name("spoon").price(BigDecimal.valueOf(34)).build();
        Item itemTwo = Item.builder().name("knife").price(BigDecimal.valueOf(12)).build();
        Item itemThird = Item.builder().name("fork").price(BigDecimal.valueOf(7)).build();

        Bucket bucket = Bucket.builder().own("przodownik").items(Lists.newArrayList(itemOne,itemThird,itemTwo)).build();
        bucketRepo.save(bucket);
        log.info("{}",bucketRepo.findAll());
    }

    @Test
    public void shouldSave(){
        assertThat(bucketRepo).isNotNull();
    }

}
