package com.kovalevskyi.academy.codingbootcamp.week2.day1;

/** Class. */
public class TextPrinter2 {
  /** Main method. */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Please provide 2 input argument, current amount: " + args.length);
      return;
    }
    String symbol = args[0];
    String text = args[1];
    if (text.equals("")) {
      drawWithEmptyLine(symbol);
    } else {
      drawWithText(text, symbol);
    }
  }

  /** Method. */
  public static void drawWithEmptyLine(String symbol) {
    int l = 4;
    int w = 3;
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < l; j++) {
        if (i == 0 || i == w - 1 || j == 0 || j == l - 1) {
          System.out.print(symbol);
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  /** Method. */
  public static void drawWithText(String text, String symbol) {
    int l = text.length() + 4;
    int w = 3;
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < l; j++) {
        if (i == 1 && j == 1) {
          System.out.print(symbol + " " + text + " " + symbol);
        } else if (i != 1) {
          System.out.print(symbol);
        }
      }
      System.out.println();
    }
  }
}
