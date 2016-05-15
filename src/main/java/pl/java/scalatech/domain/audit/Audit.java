package pl.java.scalatech.domain.audit;

import java.time.ZonedDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public abstract class Audit  extends AbstractEntity {
    private static final long serialVersionUID = 2663518387056045900L;

    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    @CreatedBy
    private String createdBy;

    @LastModifiedBy

    private String lastModifiedBy;

}
