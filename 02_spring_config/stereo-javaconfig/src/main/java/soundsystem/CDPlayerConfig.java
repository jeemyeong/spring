package soundsystem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
  
  @Bean(value = "compactDisc", initMethod = "initCompactDisc", destroyMethod = "destoryCompactDisc")
  public CompactDisc compactDisc() {
    System.out.println("compactDisc Bean called");
    return new SgtPeppers();
  }
  
  @Bean(name="cdPlayer", initMethod = "initCdPlayer", destroyMethod = "destroyCdPlayer")
  public CDPlayer cdPlayer(CompactDisc compactDisc) {
    System.out.println("cdPlayer Bean called");
    return new CDPlayer(compactDisc);
  }

}
