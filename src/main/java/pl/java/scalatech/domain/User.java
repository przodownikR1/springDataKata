
package pl.java.scalatech.domain;

import static java.time.LocalDate.now;
import static java.time.Period.between;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity{

    public static interface OnlyLoginView {}
    public static interface OnlyEmailView {}
    public static interface OnlyEnabledView {}
    public static interface OnlyVersionView {}
    public static interface AllView extends OnlyLoginView, OnlyEmailView, OnlyEnabledView, OnlyVersionView {}

    private static final long serialVersionUID = -8920961125119379475L;
    private  String firstname;
    @JsonView(User.OnlyEmailView.class)
    private  String email;
    @JsonView(User.OnlyLoginView.class)
    private String login;
    private String password;
    @JsonView(User.OnlyEnabledView.class)
    private boolean enabled;
    @Transient
    private LocalDate birthDate;

    private String lastName;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "roleId") })
    // @Valid
    private List<Role> roles ;

    public static Function<User,Integer> daysSinceBirth(){
        return x -> between(x.getBirthDate(),LocalDate.now()).getDays();
      }

    public static Predicate<User> isOlderThan(final LocalDate localDate){
        return x -> x.getBirthDate().isBefore(localDate);
      }

    public static Predicate<User> isOlderThanOrEqual(final LocalDate localDate){
        return isOlderThan(localDate).or( x -> x.getBirthDate().isEqual(localDate));
      }

    public static Predicate<User> isAnAdult(){
        return isOlderThanOrEqual(LocalDate.now().minus(18, ChronoUnit.YEARS));
      }
    public static Function<User,Integer> age(){
        return x -> now().getYear() - x.getBirthDate().getYear();
      }

    @Override
    @JsonView(User.OnlyVersionView.class)
    public Long getVersion() {
        return super.getVersion();
    }


}
