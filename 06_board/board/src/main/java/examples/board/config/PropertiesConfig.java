package examples.board.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class PropertiesConfig {

    @Autowired
    private ApplicationContext applicationContext;


    @Bean("jpaProperties")
    public Properties jpaProperties() throws IOException {
        String path = "classpath:properties/jpa.properties";
        return newInstance(path);
    }

    @Bean("jdbcProperties")
    public Properties mailJdbcProperties() throws IOException {
        String path = "classpath:properties/mysql.jdbc.properties";
        return newInstance(path);
    }

    private Properties newInstance(String path) throws IOException {
        Resource resource = applicationContext.getResource(path);
        Properties props = new Properties();
        props.load(resource.getInputStream());
        return props;
    }
}

