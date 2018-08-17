package pl.mateuszgorski.multithreading;

public class Producer implements Runnable {

  private Container container;

  public Producer(Container container) {
    this.container = container;
  }

  @Override
  public void run() {
    int i = 1;
    while (true) {
      container.put(String.valueOf(i++));
    }
  }
}

