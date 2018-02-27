package examples.board.config;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class)
        },
        basePackages = {
                "examples.board"
        })
public class ServletContextConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        /** restApi 설정 **/
        Jackson2ObjectMapperFactoryBean jsonObjectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();
        jsonObjectMapperFactoryBean.setModulesToInstall(Jdk8Module.class);
        jsonObjectMapperFactoryBean.afterPropertiesSet();

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        jsonConverter.setObjectMapper(jsonObjectMapperFactoryBean.getObject());

        converters.add(jsonConverter);

        super.configureMessageConverters(converters);
    }
}

