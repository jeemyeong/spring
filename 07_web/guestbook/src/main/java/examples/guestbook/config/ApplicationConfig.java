package examples.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "examples.guestbook.dao",  "examples.guestbook.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}