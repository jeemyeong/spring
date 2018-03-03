package examples.daoexam.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * Created by Jeemyeong.
 * User: jeemyeonglee
 * Date: 27/02/2018
 * Time: 12:45 AM
 */
public class LifeCycleTest2 implements InitializingBean, BeanNameAware, ApplicationContextAware {
    public LifeCycleTest2() {
        System.out.println("2, Constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2, setBeanName: " + name);
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("2, postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2, afterPropertiesSet");
    }

    public void init() {
        System.out.println("2, init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("2, setApplicationContext");
    }
}
