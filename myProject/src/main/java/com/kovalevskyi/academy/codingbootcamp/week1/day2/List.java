package com.kovalevskyi.academy.codingbootcamp.week1.day2;

import java.util.function.Function;

/**
 * My LinkedList.
 *
 * @param <T> generic
 */
public class List<T> {
  private List<T> prev;
  private List<T> next;
  private final T value;

  private List(List<T> prev, List<T> next, T value) {
    this.prev = prev;
    this.next = next;
    this.value = value;
  }

  public static <T> List<T> createOne(T value) {
    return new List<T>(null, null, value);
  }

  /**
   * Method.
   *
   * @param list List T
   * @param newValue T
   * @return new element
   */
  public static <T> List<T> addToEnd(List<T> list, T newValue) {
    while (list.next != null) {
      list = list.next;
    }
    List<T> temp = createOne(newValue);
    list.setNext(temp);
    temp.setPrev(list);
    return list.next;
  }

  /**
   * Method.
   *
   * @param list List T
   * @param newValue T
   * @return new element
   */
  public static <T> List<T> addToStart(List<T> list, T newValue) {
    while (list.prev != null) {
      list = list.prev;
    }
    List<T> temp = createOne(newValue);
    list.setPrev(temp);
    temp.setNext(list);
    return list.prev;
  }

  /**
   * Method.
   *
   * @param list List
   * @param value type T
   * @return boolean result
   */
  public static <T> boolean contains(List<T> list, T value) {
    boolean result = false;
    while (list.next != null) {
      list = list.next;
      if (list.value.equals(value)) {
        result = true;
        break;
      }
    }
    while (list.prev != null) {
      list = list.prev;
      if (list.value.equals(value)) {
        result = true;
        break;
      }
    }
    return result;
  }

  /** Разобраться с этим методом !!! */
  private List<T> findFirst() {
    if (this.getPrev() != null) {
      for (List<T> i = this.getPrev(); i != null; i = i.getPrev()) {
        if (i.getPrev() == null) {
          return i;
        }
      }
    }

    return this;
  }
  /** Разобраться с этим методом !!! */
  public static <T, R> List<R> map(List<T> list, Function<T, R> mapFunction) {
    List<T> firstList = list.findFirst();
    List<R> newList = List.createOne(mapFunction.apply(firstList.value));

    for (List<T> i = firstList.getNext(); i != null; i = i.getNext()) {
      List<R> newElement = List.createOne(mapFunction.apply(i.getValue()));
      newElement.setPrev(newList);
      newList.setNext(newElement);
      newList = newElement;
    }

    return newList;
  }

  /**
   * Вставляем лист со значением newValue После текущего элемента.
   *
   * @param newValue type T
   * @return new List(newValue) after current element
   */
  public List<T> insertAfter(T newValue) {
    List<T> temp = createOne(newValue);
    if (this.getNext() == null) {
      this.setNext(temp);
    } else {
      List<T> another = this.getNext();
      this.setNext(temp);
      another.setPrev(temp);
      temp.setNext(another);
    }
    temp.setPrev(this);
    return temp;
  }

  /**
   * Вставляем массив типа T в текущий лист с помощью ранее написанного метода insertAfter
   *
   * @param newValues
   */
  public void insertAfter(T[] newValues) {
    for (T value : newValues) {
      this.insertAfter(value);
    }
  }

  /**
   * Определяем длину списка.
   *
   * @return int length
   */
  public int length() {
    int ln = 1;
    for (List<T> list = this.getPrev(); list != null; list = list.getPrev()) {
      ln++;
    }
    for (List<T> list = this.getNext(); list != null; list = list.getNext()) {
      ln++;
    }
    return ln;
  }

  /** Method. */
  public void delete() {
    if (this.getNext() != null && this.getPrev() != null) {
      this.getNext().setPrev(this.getPrev());
      this.getPrev().setNext(this.getNext());
    }
    if (this.getNext() != null && this.getPrev() == null) {
      this.getNext().setPrev(null);
    }
    if (this.getNext() == null && this.getPrev() != null) {
      this.getPrev().setNext(null);
    }
  }

  public void connect(List<T> to) {
    this.setNext(to);
    to.setPrev(this);
  }

  public List<T> getNext() {
    return next;
  }

  public List<T> getPrev() {
    return prev;
  }

  public void setPrev(List<T> prev) {
    this.prev = prev;
  }

  public void setNext(List<T> next) {
    this.next = next;
  }

  public T getValue() {
    return this.value;
  }
}
