package examples.board.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        basePackages = {"examples.board"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
public class JpaPersistentConfig {

    @Value("#{jpaProperties['hibernate.show_sql']}")
    private String hibernateShowSql;
    @Value("#{jpaProperties['hibernate.format_sql']}")
    private String hibernateFormatSql;
    @Value("#{jpaProperties['hibernate.use_sql_comments']}")
    private String hibernateUseSqlComments;

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean commonEntityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPersistenceUnitName("persistenceUnit");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan(new String[]{
                "examples.board.entity"
        });

        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", hibernateShowSql);
        properties.setProperty("hibernate.format_sql", hibernateFormatSql);
        properties.setProperty("hibernate.use_sql_comments", hibernateUseSqlComments);
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.id.new_generator_mappings","false"); // hibernate_sequence 테이블을 이용해서 id를 관리하지 않도록 한다.
        emf.setJpaProperties(properties);

        return emf;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager mailTransactionManager(@Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean emf) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf.getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
