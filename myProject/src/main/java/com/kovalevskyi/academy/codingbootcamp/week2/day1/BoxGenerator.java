package com.kovalevskyi.academy.codingbootcamp.week2.day1;

import com.kovalevskyi.academy.codingbootcamp.week1.day1.StringUtils;

/** Class. */
public class BoxGenerator {
  /** Main method. */
  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.println("Please provide 4 input arguments, current amount: " + args.length);
      return;
    }
    int width;
    int length;
    try {
      width = StringUtils.toInt(args[0].toCharArray());
    } catch (NumberFormatException n) {
      throw new IllegalArgumentException();
    }
    length = StringUtils.toInt(args[1].toCharArray());
    String side = args[2];
    String corner = args[3];
    if (width < 0
        || length < 0
        || side.toCharArray().length > 1
        || corner.toCharArray().length > 1) {
      throw new IllegalArgumentException();
    }
    draw(length, width, side, corner);
  }

  /** Method. */
  public static void draw(int w, int l, String s, String c) {
    if (w == 0 || l == 0) {
      System.out.print("");
      return;
    }
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < l; j++) {
        if (i == 0 || i == w - 1 || j == 0 || j == l - 1) {
          if (i == 0 && j == 0
              || i == 0 && j == l - 1
              || j == 0 && i == w - 1
              || j == l - 1 && i == w - 1) {
            System.out.print(c);
          } else {
            System.out.print(s);
          }
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
