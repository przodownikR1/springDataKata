package pl.java.scalatech.example;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.assertj.core.util.Lists;
import org.javamoney.moneta.Money;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.TestJpaConfig;
import pl.java.scalatech.domain.example.Cart;
import pl.java.scalatech.domain.example.Product;
import pl.java.scalatech.repository.CartRepository;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestJpaConfig.class,JpaRepositoriesAutoConfiguration.class})
public class CartTest {
    @Autowired
    private CartRepository cartRepository;
    
    @Test
    public void shouldPersistAndRetrieve(){
        CurrencyUnit currency = Monetary.getCurrency(Locale.US);
        Product tv = Product.builder().name("tv").price(Money.of(10, currency)).build();
        Product gameConsole = Product.builder().name("playstation").price(Money.of(100, currency)).build();
        Product amplituner = Product.builder().name("amplituner").price(Money.of(45, currency)).build();
        Cart cart = Cart.builder().name("przodownik").products(newArrayList(tv,gameConsole,amplituner)).build();
        
        cartRepository.save(cart);
        Cart cartLoaded = cartRepository.findOne(1l);
        log.info("{}",cartLoaded);
        
    }
    
}
