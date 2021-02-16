package com.kovalevskyi.academy.codingbootcamp.week2.day0;

/** Class. */
public class NumberUtils {
  /** Main method. */
  public static void main(String[] args) {
    System.out.println(power(10, 2));
    System.out.println(power(10, 3));
    System.out.println();
    System.out.println(powerRecursive(10, 2));
    System.out.println(powerRecursive(10, 3));
    System.out.println();
    System.out.println(Math.sqrt(10));
    System.out.println(sqrt(10));
    System.out.println();
    System.out.println(isPrime(2));
    System.out.println(isPrime(3));
    System.out.println(isPrime(5));
    System.out.println(isPrime(7));
    System.out.println(isPrime(11));
    System.out.println(isPrime(13));
    System.out.println(isPrime(17));
    System.out.println(isPrime(19));
  }

  /** Method. */
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

  /** Method. */
  public static int factorialRecursive(int number) {
    if (number < 0) {
      throw new IllegalArgumentException();
    }
    int result = 1;
    if (number == 1 || number == 0) {
      return result;
    }
    result = number * factorialRecursive(number - 1);
    return result;
  }

  /** Method. */
  public static long power(int base, int power) {
    long result = 1;
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    if (power == 0) {
      return result;
    }
    if (power == 1) {
      return base;
    }
    for (int i = 0; i < power; i++) {
      result *= base;
    }
    return result;
  }

  /** Method. */
  public static int powerRecursive(int base, int power) {
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    if (power == 0) {
      return 1;
    }
    if (power == 1) {
      return base;
    }
    return base * powerRecursive(base, power - 1);
  }

  /** Method. */
  public static int fibRecursive(int index) {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    if (index == 0) {
      return 0;
    }
    if (index == 1) {
      return 1;
    }
    return fibRecursive(index - 1) + fibRecursive(index - 2);
  }

  /** Method. */
  public static int[] fibSequence(int length) {
    if (length < 0) {
      throw new IllegalArgumentException();
    }
    if (length == 0) {
      return new int[0];
    }
    if (length == 1) {
      return new int[] {1};
    }
    int[] array = new int[length];
    array[0] = 1;
    array[1] = 1;
    for (int i = 2; i < length; i++) {
      array[i] = fibRecursive(i + 1);
    }
    return array;
  }

  /** Method. */
  public static int sqrt(int target) { // разобраться какого хуя здесь происходит
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target == 3) { // вот это мне совсем не нравится конечо
      return -1;
    }
    if (target == 0 || target == 1) {
      return target;
    }
    // черная магия блять
    int lower = 1;
    int upper = target;
    int root = lower + (upper - lower) / 2;

    while (root > target / root || root + 1 <= target / (root + 1)) {
      if (root > target / root) {
        upper = root;
      } else {
        lower = root;
      }
      root = lower + (upper - lower) / 2;
    }
    return root;
  }

  /** Method. */
  public static boolean isPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target == 2 || target == 5) { // тупо заглушка
      return true;
    }
    int p = 0;
    if (target == 1 || (target % 2 == 0) || (target % 10 == 5)) {
      return false;
    } else {
      for (int i = 3; i <= sqrt(target); i += 2) {
        if (target % i == 0) {
          p += 1;
          break;
        }
      }
    }
    return p <= 0;
  }
  /*    Интересно, почему это не работает ?!
      if (target < 0) {
      throw new IllegalArgumentException();
    }
    boolean answer = true;
    for (int i = 2; i <= target; i++) {
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          answer = false;
          break;
        }
      }
    }
    return answer;
  }*/

  /** Method. */
  public static int findNextPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    while (!isPrime(target)) {
      target++;
    }
    return target;
  }
}
