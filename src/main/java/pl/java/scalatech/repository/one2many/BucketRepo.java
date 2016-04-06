package pl.java.scalatech.repository.one2many;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.one2many.Bucket;

public interface BucketRepo extends JpaRepository<Bucket, Long>{

}
