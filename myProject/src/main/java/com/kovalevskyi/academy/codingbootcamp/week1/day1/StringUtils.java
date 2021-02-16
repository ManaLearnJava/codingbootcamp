package com.kovalevskyi.academy.codingbootcamp.week1.day1;

/** Class. */
public class StringUtils {

  /**
   * Method.
   *
   * @param ch type char
   * @return boolean
   */
  public static boolean isAsciiUppercase(char ch) {
    isChar(ch);
    return (ch > 64 && ch < 91);
  }

  /**
   * Method.
   *
   * @param ch type char
   * @return boolean
   */
  public static boolean isAsciiLowercase(char ch) {
    isChar(ch);
    return (ch > 96 && ch < 123);
  }

  /**
   * Method.
   *
   * @param ch type char
   * @return boolean
   */
  public static boolean isAsciiNumeric(char ch) {
    isChar(ch);
    return (ch > 47 && ch < 58);
  }

  /**
   * Method.
   *
   * @param ch type char
   * @return boolean
   */
  public static boolean isAsciiAlphabetic(char ch) {
    isChar(ch);
    return (isAsciiUppercase(ch) || isAsciiLowercase(ch));
  }

  /**
   * Method.
   *
   * @param ch type char
   * @return boolean
   */
  public static char toAsciiUppercase(char ch) {
    isChar(ch);
    if (isAsciiLowercase(ch)) {
      return (char) (ch - 32);
    }
    return ch;
  }

  /**
   * Method.
   *
   * @param ch type char
   * @return char
   */
  public static char toAsciiLowercase(char ch) {
    isChar(ch);
    if (isAsciiUppercase(ch)) {
      return (char) (ch + 32);
    }
    return ch;
  }

  /**
   * Method.
   *
   * @param input type char[]
   * @return StringBuilder
   */
  public static StringBuilder makeUppercase(char[] input) {
    StringBuilder up = new StringBuilder();
    for (char c : input) {
      up.append(toAsciiUppercase(c));
    }
    return up;
  }

  /**
   * Method.
   *
   * @param input type char[]
   * @return StringBuilder
   */
  public static StringBuilder makeLowercase(char[] input) {
    StringBuilder low = new StringBuilder();
    for (char c : input) {
      low.append(toAsciiLowercase(c));
    }
    return low;
  }

  /**
   * Method.
   *
   * @param input type char[]
   * @return StringBuilder
   */
  public static StringBuilder makeCamel(char[] input) {
    StringBuilder camel = new StringBuilder();
    for (int i = 0; i < input.length - 1; i += 2) { // переделать через % 2 == 0
      camel.append(toAsciiLowercase(input[i]));
      camel.append(toAsciiUppercase(input[i + 1]));
    }
    return camel.append(toAsciiLowercase(input[input.length - 1]));
  }

  /**
   * Method.
   *
   * @param input type char[]
   * @return boolean
   */
  public static boolean isStringAlphaNumerical(char[] input) {
    boolean result = false;
    int hits = 0;
    for (char c : input) {
      isChar(c);
      if (isAsciiNumeric(c) || isAsciiAlphabetic(c) || c == 32) {
        hits++;
      }
    }
    if (hits == input.length) {
      result = true;
    }
    return result;
  }

  /**
   * Method.
   *
   * @param input char[][]
   * @return char[]
   */
  public static char[] concatStrings(char[][] input) {
    int length = 0;
    for (int i = 0; i < input.length; i++) {
      length += input[i].length;
    }
    char[] output = new char[length];
    for (int a = 0; a < output.length; ) {
      for (int i = 0; i < input.length; i++) {
        for (int j = 0; j < input[i].length; j++, a++) {
          isChar(input[i][j]);
          output[a] = input[i][j];
        }
      }
    }
    return output;
  }

  /**
   * Method.
   *
   * @param input char[]
   * @return int
   */
  public static int toInt(char[] input) {
    int number = 0;
    boolean isNegative = false;
    for (int i = 0; i < input.length; i++) {
      if (input[i] == (char) 45) {
        isNegative = true;
        continue;
      }
      if (!isAsciiNumeric(input[i])) {
        throw new NumberFormatException();
      }
      number *= 10;
      number += (input[i] - '0');
    }
    return isNegative ? -number : number;
  }

  /**
   * Method.
   *
   * @param ch type char
   */
  public static void isChar(char ch) {
    if (ch > 255) {
      throw new IllegalArgumentException();
    }
  }
}
