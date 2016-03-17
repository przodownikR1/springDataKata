package pl.java.scalatech.config;

import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@ComponentScan(basePackages= {"pl.java.scalatech.repository"})
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
@EntityScan(basePackages="pl.java.scalatech.domain")
@PropertySource(value="classpath:application-test.properties")
@Import({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,PersistenceExceptionTranslationAutoConfiguration.class,
    PropertyPlaceholderAutoConfiguration.class})
public class TestJpaConfig {

 /* //TODO how to set minimal spring boot config to start working log sql 
    @Bean
    @Primary
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        hibernateJpaVendorAdapter.getJpaPropertyMap().put("hibernate.generate_statistics", true);
        return hibernateJpaVendorAdapter;
    }*/
}
