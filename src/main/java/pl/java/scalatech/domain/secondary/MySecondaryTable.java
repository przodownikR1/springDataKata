package pl.java.scalatech.domain.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.domain.AbstractEntity;

@Entity
@SecondaryTable(name="SecondaryTable")
@Table(name="MainTable")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MySecondaryTable extends AbstractEntity{

    private static final long serialVersionUID = 4237306404572688516L;

    private String mainField1;

    @Column(table="SecondaryTable")
    private String secoField1;
}



