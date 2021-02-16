package com.kovalevskyi.academy.codingbootcamp.week2.day1;

/** Class. */
public class TextPrinter extends BoxGenerator {
  /** Main method. */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Please provide only one input argument, current amount: " + args.length);
      return;
    }
    String s = args[0];
    if (s.equals("")) {
      drawWithEmptyLine();
    } else {
      drawWithText(s);
    }
  }

  /** Method. */
  public static void drawWithEmptyLine() {
    int l = 4;
    int w = 3;
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < l; j++) {
        if (i == 0 || i == w - 1 || j == 0 || j == l - 1) {
          if (i == 0 && j == 0 || j == l - 1 && i == w - 1) {
            System.out.print("/");
          } else if (i == 0 && j == l - 1 || i == w - 1 && j == 0) {
            System.out.print("\\");
          } else {
            System.out.print("#");
          }
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  /** Method. */
  public static void drawWithText(String word) {
    int l = word.length() + 4;
    int w = 3;
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < l; j++) {
        if (i == 1 && j == 1) {
          System.out.print("# " + word + " #");
        }
        if (i == 0 && j == 0 || j == l - 1 && i == w - 1) {
          System.out.print("/");
        } else if (i == 0 && j == l - 1 || i == w - 1 && j == 0) {
          System.out.print("\\");
        } else if (i != 1) {
          System.out.print("#");
        }
      }
      System.out.println();
    }
  }
}
