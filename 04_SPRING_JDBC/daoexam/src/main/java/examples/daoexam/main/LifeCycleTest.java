package examples.daoexam.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Jeemyeong.
 * User: jeemyeonglee
 * Date: 27/02/2018
 * Time: 12:45 AM
 */
public class LifeCycleTest implements InitializingBean, BeanNameAware, ApplicationContextAware {
    public LifeCycleTest() {
        System.out.println("Constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName: " + name);
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void init() {
        System.out.println("init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }
}
