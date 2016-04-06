package pl.java.scalatech.domain.one2many;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.java.scalatech.domain.AbstractEntity;
import pl.java.scalatech.domain.Item;
@Entity
@Table(name="bucket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Bucket extends AbstractEntity{

    private static final long serialVersionUID = -8390698099436244116L;

    private String own;

    @OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
    private List<Item> items;

}
