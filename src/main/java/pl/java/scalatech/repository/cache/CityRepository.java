package pl.java.scalatech.repository.cache;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import pl.java.scalatech.domain.cache.City;

interface CityRepository extends Repository<City, Long> {

	Page<City> findAll(Pageable pageable);

	Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name, String country,
			Pageable pageable);

	City findByNameAndCountryAllIgnoringCase(String name, String country);

}