package com.kovalevskyi.academy.codingbootcamp.week0.day1;

/** Super mega power class. */
public class Numbers1 {
  /**
   * Generate an array of 100 numbers from 0 to 99.
   *
   * @return int[] numbers
   */
  public static int[] generateNumbers() {
    int[] numbers = new int[100];
    for (int i = 0; i < 100; i++) {
      numbers[i] = i;
    }
    return numbers;
  }

  /**
   * Find the maximum of 2 numbers.
   *
   * @param left int
   * @param right int
   * @return int max
   */
  public static int findBiggest(int left, int right) {
    int max = left > right ? left : right;
    return max;
  }

  /**
   * Find the maximum of 3 numbers.
   *
   * @param left int
   * @param mid int
   * @param right int
   * @return int max
   */
  public static int findBiggest(int left, int mid, int right) {
    // int max = left > mid ? (left > right ? left : right) : (mid > right ? mid : right);
    int number = findBiggest(left, right);
    int max = mid > number ? mid : number;
    return max;
  }

  /**
   * Find the biggest number in the array.
   *
   * @param numbers array
   * @return int max
   */
  public static int findBiggest(int[] numbers) {
    int max;
    if (numbers != null && numbers.length > 0) {
      max = numbers[0];
      for (int i = 0; i < numbers.length; i++) {
        if (max < numbers[i]) {
          max = numbers[i];
        }
      }
    } else {
      throw new IllegalArgumentException();
    }
    return max;
  }

  /**
   * Find the index of the biggest number in the array.
   *
   * @param numbers array
   * @return int index
   */
  public static int findIndexOfBiggestNumber(int[] numbers) {
    int max;
    int index;
    if (numbers != null && numbers.length > 0) {
      max = numbers[0];
      index = 0;
      for (int i = 0; i < numbers.length; i++) {
        if (max < numbers[i]) {
          max = numbers[i];
          index = i;
        }
      }
    } else {
      throw new IllegalArgumentException();
    }
    return index;
  }

  /**
   * Find out is the number is negative.
   *
   * @param number int
   * @return boolean answer
   */
  public static boolean isNegative(int number) {
    return number < 0;
  }

  /**
   * Convert int[] array to char[] array.
   *
   * @param number int
   * @return char[] array
   */
  public static char[] convertToCharArray(int number) {
    boolean isNegative = isNegative(number);
    int ln = 0;
    long tmp = number;
    if (isNegative || number == 0) {
      ln = 1;
    }
    while (tmp != 0) {
      tmp /= 10;
      ln++;
    }
    char[] array = new char[ln];
    for (int i = ln - 1; i >= 0; i--) {
      array[i] = isNegative ? (char) (number % 10 * -1 + '0') : (char) (number % 10 + '0');
      number /= 10;
    }
    if (isNegative) {
      array[0] = 45;
    }
    return array;
  }
}
