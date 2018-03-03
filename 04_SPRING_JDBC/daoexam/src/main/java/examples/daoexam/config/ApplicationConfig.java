package examples.daoexam.config;

import examples.daoexam.main.ApplicationListenerBean;
import examples.daoexam.main.LifeCycleTest;
import examples.daoexam.main.LifeCycleTest2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "examples.daoexam.dao" })
@Import({ DBConfig.class })
public class ApplicationConfig {
    @Bean(initMethod = "init")
    LifeCycleTest getLifeCycleTest() {
        return new LifeCycleTest();
    }

    @Bean(initMethod = "init")
    LifeCycleTest2 getLifeCycleTest2() {
        return new LifeCycleTest2();
    }

    @Bean
    ApplicationListenerBean getApplicationListenerBean() {
        return new ApplicationListenerBean();
    }
}