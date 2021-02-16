package com.kovalevskyi.academy.codingbootcamp.week1.day0;

import java.util.Comparator;

/** Super mega power class. */
public class Sorting {

  /**
   * Method.
   *
   * @param target array
   * @param comparator type T
   * @param <T> type
   */
  public static <T> void sort(T[] target, Comparator<T> comparator) {
    boolean isSorted;
    if (target == null || target.length == 0) {
      throw new NullPointerException();
    }
    do {
      isSorted = false;
      for (int i = 0; i < target.length - 1; i++) {
        if (comparator.compare(target[i], target[i + 1]) > 0) {
          toSwap(target, i);
          isSorted = true;
        }
      }
    } while (isSorted);
  }

  /**
   * Method.
   *
   * @param target array
   * @param comparator type T
   * @param <T> type
   */
  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {

    if (target == null || target.length == 0) {
      throw new NullPointerException();
    }
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < target.length - 1; i++) {
        if (comparator.compare(target[i], target[i + 1]) < 0) {
          isSorted = false;
          toSwap(target, i);
        }
      }
    }
  }

  /**
   * My method toSwap.
   *
   * @param array type T
   * @param i index type int
   * @param <T> type
   */
  public static <T> void toSwap(T[] array, int i) {
    T tmp;
    tmp = array[i + 1];
    array[i + 1] = array[i];
    array[i] = tmp;
  }
}
