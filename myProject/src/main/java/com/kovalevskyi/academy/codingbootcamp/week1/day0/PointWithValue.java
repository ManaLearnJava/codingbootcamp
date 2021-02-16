package com.kovalevskyi.academy.codingbootcamp.week1.day0;

import com.kovalevskyi.academy.codingbootcamp.week0.day3.Point;
import java.util.function.Function;

/**
 * Class.
 *
 * @param <T> type
 */
public class PointWithValue<T> extends Point {
  T value;

  public PointWithValue(int cordinateX, int cordinateY, T value) {
    super(cordinateX, cordinateY);
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public <R> PointWithValue<R> mapPoint(Function<T, R> mapFunction) {
    return new PointWithValue<>(getX(), getY(), mapFunction.apply(value));
  }

  @Override
  public String toString() {
    return "PointWithValue{" + " X: " + getX() + ", Y: " + getY() + ", value: " + value + '}';
  }
}
