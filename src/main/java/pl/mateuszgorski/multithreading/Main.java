package pl.mateuszgorski.multithreading;

public class Main {

  public static void main(String[] args) {
    Container container = new Container(10);
    Thread producerA = new Thread(new Producer(container), "Producer A");
    Thread producerB = new Thread(new Producer(container), "Producer B");
    Thread consumerA = new Thread(new Consumer(container), "Consumer A");
    Thread consumerB = new Thread(new Consumer(container), "Consumer B");
    producerA.start();
    producerB.start();
    consumerA.start();
    consumerB.start();
  }
}
