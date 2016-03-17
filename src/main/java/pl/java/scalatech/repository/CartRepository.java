package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.example.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
