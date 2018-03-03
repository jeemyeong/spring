package examples.daoexam.main;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by Jeemyeong.
 * User: jeemyeonglee
 * Date: 27/02/2018
 * Time: 12:56 AM
 */
public class ApplicationListenerBean implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("onApplicationEvent " + event.toString());
    }
}
