package pl.mateuszgorski.christmas;

import java.util.Scanner;

public class ChristmasTree {

    /* Returns Array of String containing ChristmasTree elements*/
    public static String[] growChristmasTree(int size) {
        int trunkWidth = (size / 10) % 2 == 0 ? size / 10 + 1 : size / 10 + 2;
        int trunkHeight = trunkWidth / 3 + 1;
        int whereTrunkStarts = size - trunkWidth / 2 - 1;
        String[] christmasTreeArray = new String[size + trunkHeight];
        for (int i = 0; i < (size + trunkHeight); i++) {
            christmasTreeArray[i] = "";
        }
        /* Create tree branches depending on int size param*/
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size - i - 1); j++) {
                christmasTreeArray[i] += (" ");
            }
            for (int k = 1; k <= i * 2 + 1; k++) {
                christmasTreeArray[i] += ("*");
            }
        }
        /*Create tree trunk */
        for (int i = 0; i < trunkHeight; i++) {
            for (int j = 0; j < whereTrunkStarts; j++) {
                christmasTreeArray[size + i] += (" ");
            }
            for (int k = 0; k < trunkWidth; k++) {
                christmasTreeArray[size + i] += ("*");
            }
        }
        return christmasTreeArray;
    }

    public static void showChristmasTree(String[] christmasTreeArray) {
        for (String j : christmasTreeArray) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        System.out.println("How tall is the tree?");
        Scanner scanner = new Scanner(System.in);
        int numberOfBranches = scanner.nextInt();
        if (numberOfBranches < 3) {
            System.out.println(" It's too early to cut it!");
        } else {
            String[] christmasTree = growChristmasTree(numberOfBranches);
            showChristmasTree(christmasTree);
        }
    }
}
