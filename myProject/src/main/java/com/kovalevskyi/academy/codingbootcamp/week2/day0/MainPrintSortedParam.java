package com.kovalevskyi.academy.codingbootcamp.week2.day0;

import com.kovalevskyi.academy.codingbootcamp.week1.day0.Sorting;
// import java.util.Comparator;

/** Class. */
public class MainPrintSortedParam {
  /**
   * Main method.
   *
   * @param args type String[]
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
    } else {
      Sorting.sort(args, String::compareTo); // Comparator.naturalOrder()
      for (String s : args) {
        System.out.println(s);
      }
    }
  }
}
