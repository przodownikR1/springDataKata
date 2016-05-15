package pl.java.scalatech.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.audit.SpringSecurityAuditorAware;

@Configuration
@Slf4j
@EnableJpaAuditing
public class AuditConfig {
    @PostConstruct
    public void init(){
      log.info("++++ auditConfig started");
    }
    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }

}
