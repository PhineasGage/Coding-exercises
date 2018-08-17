package pl.mateuszgorski.multithreading;

public class Container {

  private String[] containerContent;
  private int putIndex;
  private int takeIndex;
  private int count;

  public Container(int size) {
    this.containerContent = new String[size];
  }

  private synchronized void increasePutIndex() {
    if (putIndex == containerContent.length - 1) {
      putIndex = 0;
    } else {
      putIndex++;
    }
  }

  private synchronized void increaseTakeIndex() {
    if (takeIndex == containerContent.length - 1) {
      takeIndex = 0;
    } else {
      takeIndex++;
    }
  }

  public synchronized void put(String element) {
    while (count == containerContent.length) {
      try {
        System.out.println(Thread.currentThread().getName() + " waiting to put");
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    containerContent[putIndex] = element;
    increasePutIndex();
    count++;
    notify();
    System.out
        .println(Thread.currentThread().getName() + " Put " + element + ", element count " + count);
  }

  public synchronized String take() {
    while (count == 0) {
      try {
        System.out.println(Thread.currentThread().getName() + " waiting to take");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    count--;
    String returnElement = containerContent[takeIndex];
    increaseTakeIndex();
    notify();
    System.out.println(
        Thread.currentThread().getName() + " Took " + returnElement + ", element count " + count);
    return returnElement;
  }
}