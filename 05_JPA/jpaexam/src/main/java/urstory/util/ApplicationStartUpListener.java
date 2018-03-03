package urstory.util;

import com.mysema.util.ClassPathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

public class ApplicationStartUpListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartUpListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.debug("ApplicationStartUpListener.onApplicationEvent started");

        ApplicationContext context = (ApplicationContext) event.getSource();
        try {
            // When Querydsl Q-types are initialized from multiple threads, deadlocks can occur,
            // if the Q-types have circular dependencies.
            // http://www.querydsl.com/static/querydsl/3.5.0/reference/html/ch04s02.html
            ClassPathUtils.scanPackage(context.getClassLoader(), "urstory.entity");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
