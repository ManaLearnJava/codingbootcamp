package com.kovalevskyi.academy.codingbootcamp.week1.day0;

import com.kovalevskyi.academy.codingbootcamp.week0.day3.Point;

/** Class. */
public class PointWithLabel extends PointWithValue<String> {
  public PointWithLabel(int cordinateX, int cordinateY, String value) {
    super(cordinateX, cordinateY, value);
  }

  public String getLabel() {
    return value;
  }

  @Override
  public int compareTo(Point that) {
    if (this.getClass() != that.getClass()) {
      return super.compareTo(that);
    }
    return this.value.compareTo(((PointWithLabel) that).value);
  }
}
