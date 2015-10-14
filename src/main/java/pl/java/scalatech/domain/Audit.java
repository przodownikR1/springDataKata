package pl.java.scalatech.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Audit implements Serializable{
    private static final long serialVersionUID = 2663518387056045900L;

    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();
    
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Person createdBy;

    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Person lastModifiedBy;

}
