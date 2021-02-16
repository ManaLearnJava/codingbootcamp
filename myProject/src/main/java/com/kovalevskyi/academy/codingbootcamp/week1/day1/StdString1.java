package com.kovalevskyi.academy.codingbootcamp.week1.day1;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/** Difficult class. */
public class StdString1 implements Iterable<Character> {
  protected final char[] base;

  public StdString1(char[] base) {
    this.base = base.clone();
  }

  public StdString1() {
    this(new char[0]);
  }

  public StdString1(StdString1 stdString1) {
    this(stdString1.base);
  }

  /**
   * Method.
   *
   * @return int
   */
  public int length() {
    return base.length;
  }

  /**
   * Method.
   *
   * @param that type StdString1
   * @return new StdString1
   */
  public StdString1 append(StdString1 that) { // переделать через StringBuilder append
    int index = 0;
    if (that == null) {
      throw new NullPointerException();
    }
    if (that.base.length == 0) {
      return new StdString1(base);
    }
    int ln = this.base.length + that.base.length;
    char[] chars = new char[ln];
    for (int i = 0; i < this.base.length; i++) {
      chars[i] = this.base[i];
    }
    for (int j = this.base.length; j < ln; j++) {
      chars[j] = that.base[index++];
    }
    return new StdString1(chars);
  }

  public char[] toCharArray() {
    return this.base;
  }

  /**
   * Method.
   *
   * @param index int
   * @return char
   */
  public char charAt(int index) {
    if (index < 0 || index >= this.base.length) {
      throw new IndexOutOfBoundsException();
    }
    char c = 0;
    for (int i = 0; i < this.base.length; i++) {
      if (i == index) {
        c = this.base[i];
      }
    }
    return c;
  }

  /**
   * Method.
   *
   * @param target char
   * @return int
   */
  public int indexOf(char target) {
    int index = -1;
    for (int i = 0; i < this.base.length; i++) {
      if (target == this.base[i]) {
        index = i;
      }
    }
    return index;
  }

  @Override
  public boolean equals(final Object otherObj) {
    if (this == otherObj) {
      return true;
    }
    if (otherObj == null || getClass() != otherObj.getClass()) {
      return false;
    }
    StdString1 stdString1 = (StdString1) otherObj;
    if (this.length() != stdString1.length()) {
      return false;
    }
    for (int i = 0; i < this.base.length; i++) {
      if (this.base[i] != stdString1.base[i]) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    int code = 0;
    for (char c : this.base) {
      code += c;
    }
    return code;
  }

  @Override
  public String toString() {
    return String.valueOf(this.base);
  }

  @Override
  public Iterator<Character> iterator() {
    char[] chars = this.base;
    return new Iterator<Character>() {
      int index = 0;
      int ln = chars.length;

      @Override
      public boolean hasNext() {
        return index < ln;
      }

      @Override
      public Character next() {
        char ch = chars[index];
        index++;
        return ch;
      }
    };
  }

  @Override
  public void forEach(Consumer<? super Character> action) {
    Iterator<Character> iterator = this.iterator();
    iterator.forEachRemaining(action);
  }

  @Override
  public Spliterator<Character> spliterator() {
    return null;
  }
}
