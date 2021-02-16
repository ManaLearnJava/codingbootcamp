package com.kovalevskyi.academy.codingbootcamp.week0.day2;

import com.kovalevskyi.academy.codingbootcamp.week0.day1.Numbers1;

/** Class. */
public class Numbers2 extends Numbers1 {

  /**
   * Bubble sort.
   *
   * @param target array
   */
  public static void sort(int[] target) {
    if (target == null || target.length == 0) {
      return;
    }
    int tmp;
    int ln = target.length;
    for (int x = ln - 1; x >= 1; x--) {
      for (int y = 0; y < x; y++) {
        if (target[y] > target[y + 1]) {
          tmp = target[y + 1];
          target[y + 1] = target[y];
          target[y] = tmp;
        }
      }
    }
  }

  /**
   * Find the factorial of the number.
   *
   * @param number type int
   * @return factorial of number
   */
  public static int getFactorial(final int number) {
    if (number < 0) {
      throw new IllegalArgumentException();
    }
    int factorial = 1;
    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }
    return factorial;
  }

  /**
   * Method.
   *
   * @return array result [][]
   */
  public static char[][] generateTriplets() {
    char[][] result = new char[120][3];
    int index = 0;
    for (int a = 0; a < 8; a++) {
      for (int b = a + 1; b < 9; b++) {
        for (int c = b + 1; c < 10; c++) {
          char[] chars = new char[] {(char) (a + '0'), (char) (b + '0'), (char) (c + '0')};
          result[index] = chars;
          index++;
        }
      }
    }
    return result;
  }

  /**
   * Method.
   *
   * @return array result [][]
   */
  public static char[][] generateTuples() {
    char[][] result = new char[10000][5];
    int index = 0;
    for (int a = 0; a < 10; a++) {
      for (int b = 0; b < 10; b++) {
        for (int c = 0; c < 10; c++) {
          for (int d = 0; d < 10; d++) {
            char[] chars =
                new char[] {
                  (char) (a + '0'), (char) (b + '0'), 32, (char) (c + '0'), (char) (d + '0')
                  };
            result[index] = chars;
            index++;
          }
        }
      }
    }
    return result;
  }

  /**
   * Very interesting method.
   *
   * @param amount int
   * @return new char[number][amount]
   */
  public static char[][] generateTuples(int amount) {
    if (amount < 0 || amount > 9) {
      throw new IllegalArgumentException();
    }
    if (amount == 0) {
      return new char[0][0];
    }
    int count = power(10, amount);
    char[][] result = new char[count][amount];
    for (int i = 0; i < count; i++) {
      char[] numbers = convertToCharArray(i);
      int zeroCount = amount - numbers.length;
      char[] chars = new char[amount];
      System.arraycopy(numbers, 0, chars, zeroCount, numbers.length);
      for (int j = 0; j < zeroCount; j++) {
        chars[j] = (char) 48;
      }
      result[i] = chars;
    }
    return result;
  }

  /**
   * I've got the power.
   *
   * @param number int
   * @param count int
   * @return number * 10^count
   */
  public static int power(int number, int count) {
    number = 1;
    for (int i = 0; i < count; i++) {
      number *= 10;
    }
    return number;
  }
}
