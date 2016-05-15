package pl.java.scalatech.audit;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.repository.UserRepository;

@Slf4j
@NoArgsConstructor
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    private final static String ANONYMOUS = "anonymous";
    @Autowired
    private  UserRepository userRepository;

    Random rand = new Random();
    @Override
    public String getCurrentAuditor() {
        log.info("++++ auditor !!!");
        return "slawek"+rand.nextInt(100);
    }

  /*  @Override
    public User getCurrentAuditor() {
      //  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = ANONYMOUS;
         if(auth != null){
             login = auth.getName();
         }
        log.info("+++++++++++++++++++ +++++++++++++++++++++++++++++ login from security context : {}",login);
        Optional<User> user = userRepository.findByLogin(login);
        User loaded =  user.orElseThrow(()-> new IllegalArgumentException("user not exists"));
        log.info("+++++++++++++++++  +++++++++++++++++++++++++++++  {}",loaded);
        return loaded;
    }*/

}