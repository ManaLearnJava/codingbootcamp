package com.kovalevskyi.academy.codingbootcamp.week2.day0;

import com.kovalevskyi.academy.codingbootcamp.week1.day1.StringUtils;

/** Class. */
public class Calculator {
  /** Main method. */
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
      return;
    }
    int first;
    int second;
    String operation;

    try {
      first = StringUtils.toInt(args[0].toCharArray());
    } catch (NumberFormatException n) {
      throw new IllegalArgumentException();
    }
    if (args[1].equals("+")
        || args[1].equals("-")
        || args[1].equals("/")
        || args[1].equals("*")
        || args[1].equals("%")) {
      operation = args[1];
    } else {
      throw new IllegalArgumentException();
    }
    try {
      second = StringUtils.toInt(args[2].toCharArray());
    } catch (NumberFormatException n) {
      throw new IllegalArgumentException();
    }
    calc(first, operation, second);
  }

  /** Method. */
  public static void calc(Integer first, String s, Integer second) {
    long result;
    switch (s) {
      case "+":
        result = (long) first + second;
        break;
      case "-":
        result = (long) first - second;
        break;
      case "/":
        if (second == 0) {
          System.out.println("Division by zero is impossible!");
          return;
        }
        result = (long) first / second;
        break;
      case "*":
        result = (long) first * second;
        break;
      case "%":
        result = (long) first % second;
        break;
      default:
        result = -1;
        break;
    }
    System.out.println("result: " + result);
  }
}
