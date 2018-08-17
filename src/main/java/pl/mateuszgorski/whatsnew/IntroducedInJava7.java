package pl.mateuszgorski.whatsnew;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class IntroducedInJava7 {

  //Diamond Operator - type infference
  List<String> listOfInfferedType = new ArrayList<>();

  //Try-with-resources, two streams connected,  Jenkov tutorial
  private static void printFileJava7() throws IOException {
    try (FileInputStream input = new FileInputStream("file.txt");
        BufferedInputStream bufferedInput = new BufferedInputStream(input)) {
      int data = bufferedInput.read();
      while (data != -1) {
        System.out.print((char) data);
        data = bufferedInput.read();
      }
    }
  }

  //String in Switch statement -GeeksForGeeks
  void switchString() {
    String str = "two";
    switch (str) {
      case "one":
        System.out.println("one");
        break;
      case "two":
        System.out.println("two");
        break;
      case "three":
        System.out.println("three");
        break;
      default:
        System.out.println("no match");
    }
  }


  //Improvements to concurrent library, - Phaser below, like CyclicBarrier, but with phases, Java 8 the Complete reference, Herbert Schild
  void phaserMethod() {
    Phaser phaser = new Phaser(1);
    phaser.arriveAndAwaitAdvance();
    int curPhase;
    new MyThread(phaser, "A");
    new MyThread(phaser, "B");
    curPhase = phaser.getPhase();
    phaser.arriveAndAwaitAdvance();
    System.out.println("Phase " + curPhase + " Complete");
  }

  class MyThread implements Runnable {

    Phaser phsr;
    String name;

    MyThread(Phaser p, String n) {
      phsr = p;
      name = n;
      phsr.register();
      new Thread(this).start();
    }

    public void run() {
      System.out.println("Thread " + name + " Beginning Phase One");
      phsr.arriveAndAwaitAdvance();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
  }
}
