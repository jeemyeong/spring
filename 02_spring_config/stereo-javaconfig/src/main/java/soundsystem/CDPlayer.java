package soundsystem;
import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {
  private CompactDisc cd;

  @Autowired
  public CDPlayer(CompactDisc cd) {
    this.cd = cd;
  }

  public void play() {
    cd.play();
  }
  public void initCdPlayer() {
    System.out.println("initCdPlayer");
  }
  public void destroyCdPlayer() {
    System.out.println("destroyCdPlayer");
  }
}
