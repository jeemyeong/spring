package soundsystem;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class CDPlayerConfig {
    public CDPlayerConfig() {
        System.out.println("HELLO");
    }
}
