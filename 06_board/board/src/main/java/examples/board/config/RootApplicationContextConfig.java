package examples.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(
        value = {/**/
                PropertiesConfig.class,
                JpaPersistentConfig.class, StandaloneDataSourceConfig.class
        })
@ComponentScan(
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class)
        },
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
        },
        basePackages = {
                "examples.board"
        })
@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true)
public class RootApplicationContextConfig {

    /**
     * Environment
     **/
    @Autowired
    private Environment env;


}

