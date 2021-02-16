package com.kovalevskyi.academy.codingbootcamp.week0.day3;

/** Super mega power class. */
public class Point implements Comparable<Point> {
  final int cordinateX;
  final int cordinateY;

  public Point(final int cordinateX, final int cordinateY) {
    this.cordinateX = cordinateX;
    this.cordinateY = cordinateY;
  }

  public int getX() {
    return cordinateX;
  }

  public int getY() {
    return cordinateY;
  }

  public Point sum(final Point that) {
    return new Point(this.cordinateX + that.cordinateX, this.cordinateY + that.cordinateY);
  }

  public Point updateX(int newX) {
    return new Point(newX, cordinateY);
  }

  public Point updateY(int newY) {
    return new Point(cordinateX, newY);
  }

  /**
   * Distance between points.
   *
   * @param that Point
   * @return int distance
   */
  public int distanceTo(Point that) {
    int a = this.cordinateX - that.cordinateX;
    int b = this.cordinateY - that.cordinateY;
    int distance = (a * a) + (b * b);
    return distance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return cordinateX == point.cordinateX && cordinateY == point.cordinateY;
  }

  @Override
  public int hashCode() {
    return this.cordinateX + this.cordinateY;
  }

  @Override
  public String toString() {
    return "Point{" + "X: " + cordinateX + ", Y: " + cordinateY + '}';
  }

  @Override
  public int compareTo(Point that) {
    return this.hashCode() - that.hashCode();
  }
}
