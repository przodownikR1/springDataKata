package pl.java.scalatech.collectionElement;

import static com.google.common.collect.Sets.newHashSet;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.collectionElement.Computer;
import pl.java.scalatech.repository.computer.ComputerRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class})
public class CollectionElementTest {
    @Autowired
    private ComputerRepo computerRepo;
    @Test
    public void shouldSaveCollection(){
        computerRepo.save(new Computer("myLaptop", newHashSet("usb","vga","hdmi","sata2")));
        assertThat(computerRepo.findAll().get(0).getInterfaces()).hasSize(4);
    }

    @Test
    public void shouldInject(){
        assertThat(computerRepo).isNotNull();
    }



}
