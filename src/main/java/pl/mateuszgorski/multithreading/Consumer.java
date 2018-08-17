package pl.mateuszgorski.multithreading;

public class Consumer implements Runnable {

  private Container container;

  public Consumer(Container container) {
    this.container = container;
  }

  @Override
  public void run() {
    while (true) {
      container.take();
    }
  }
}
