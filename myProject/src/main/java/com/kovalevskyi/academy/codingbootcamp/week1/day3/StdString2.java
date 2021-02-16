package com.kovalevskyi.academy.codingbootcamp.week1.day3;

import com.kovalevskyi.academy.codingbootcamp.week1.day1.StdString1;
import com.kovalevskyi.academy.codingbootcamp.week1.day1.StringUtils;

/** Difficult class. */
public class StdString2 extends StdString1 {

  public StdString2(char[] base) {
    super(base);
  }

  public StdString2() {
    super();
  }

  public StdString2(StdString2 stdString2) {
    super(stdString2);
  }

  public StdString2 toAsciiLowerCase() {
    return new StdString2(StringUtils.makeLowercase(this.toCharArray()).toString().toCharArray());
  }

  public StdString2 toAsciiUpperCase() {
    return new StdString2(StringUtils.makeUppercase(this.toCharArray()).toString().toCharArray());
  }

  /**
   * Method.
   *
   * @param from int
   * @param to int
   * @return new StdString2
   */
  public StdString2 subString(int from, int to) {
    if (from > to) {
      throw new IllegalArgumentException();
    }
    if (from < 0 || to > this.toCharArray().length) {
      throw new IndexOutOfBoundsException();
    }
    char[] chars = new char[to - from];
    System.arraycopy(this.toCharArray(), from, chars, 0, chars.length);
    return new StdString2(chars);
  }

  /**
   * Method.
   *
   * @param that StdString2 []
   * @return new StdString2
   */
  public StdString2 concat(StdString2... that) {
    if (that == null) {
      throw new NullPointerException();
    }
    StringBuilder sb = new StringBuilder(this.toString());
    for (int i = 0; i < that.length; i++) {
      if (that[i] == null) {
        throw new NullPointerException();
      }
      sb.append(that[i]);
    }
    return new StdString2(sb.toString().toCharArray());
  }

  /**
   * Method.
   *
   * @param separator char
   * @return StdString2[]
   */
  public StdString2[] split(char separator) {
    int count = 0;

    for (char ch : this.base) {
      if (ch == separator) {
        count++;
      }
    }

    if (count == 0) {
      return new StdString2[] {this};
    }

    StdString2[] res = new StdString2[count];

    int from = 0;

    for (int i = 0, s = 0; i < length(); i++) {
      if (this.base[i] == separator && i == from) {
        res[s] = new StdString2();
        s++;
        from = i + 1;
      }

      if (this.base[i] == separator && i > from) {
        res[s] = this.subString(from, i);
        s++;
        from = i + 1;
      }
    }

    return res;
  }

  /**
   * Method.
   *
   * @return new StdString2
   */
  public StdString2 trim() {
    if (length() == 0) {
      return this;
    }
    int from = 0;
    int to = length() - 1;
    for (int i = 0; i < to; i++) {
      if (this.toCharArray()[i] == ' ') {
        from++;
      } else {
        break;
      }
    }
    for (int j = to; j > from; j--) {
      if (this.toCharArray()[j] == ' ') {
        to--;
      } else {
        to++;
        break;
      }
    }
    return subString(from, to);
  }

  /**
   * Method.
   *
   * @param toRemove char
   * @return new StdString2
   */
  public StdString2 removeCharacter(char toRemove) {
    StringBuilder sb = new StringBuilder(new StdString2().toString());
    for (int i = 0; i < length(); i++) {
      if (this.toCharArray()[i] != toRemove) {
        sb.append(this.toCharArray()[i]);
      }
    }
    return new StdString2(sb.toString().toCharArray());
  }
}
