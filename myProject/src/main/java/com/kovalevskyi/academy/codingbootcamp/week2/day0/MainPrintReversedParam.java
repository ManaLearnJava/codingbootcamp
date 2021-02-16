package com.kovalevskyi.academy.codingbootcamp.week2.day0;

/** Class. */
public class MainPrintReversedParam {
  /**
   * Main method.
   *
   * @param args type String[]
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
    } else {
      for (int i = args.length - 1; i > -1; i--) {
        System.out.println(args[i]);
      }
    }
  }
}
