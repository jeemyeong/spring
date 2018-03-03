package soundsystem;


public class SgtPeppers implements CompactDisc {

  private String title = "Sgt. Pepper's Lonely Hearts Club Band";  
  private String artist = "The Beatles";

  @Override
  public void initCompactDisc() {
    System.out.println("initCompactDisc");
  }

  @Override
  public void destoryCompactDisc() {
    System.out.println("destoryCompactDisc");
  }
  public void play() {
    System.out.println("Playing " + title + " by " + artist);
  }

}
