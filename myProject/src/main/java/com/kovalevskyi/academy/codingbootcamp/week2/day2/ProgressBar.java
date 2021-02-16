package com.kovalevskyi.academy.codingbootcamp.week2.day2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/** Class. */
public class ProgressBar {
  /** Main method. */
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println(
          "Please provide 2 or more input arguments, current amount: " + args.length);
      return;
    }
    final Random random = new Random();
    for (final String arg : args) {
      try {
        Integer.valueOf(arg);
      } catch (Exception e) {
        System.out.println("All arguments should be int");
        return;
      }
    }
    final int items = Integer.parseInt(args[0]);
    int[] secPerItem =
        Arrays.asList(args).subList(1, args.length).stream().mapToInt(Integer::valueOf).toArray();
    final long startTime = System.currentTimeMillis();
    String eta = "00:00:00";
    for (int i = 0; i <= items; ++i) {
      final double percent = i / (items / 100.0);
      if (i > 0) {
        final long currentTime = System.currentTimeMillis();
        final long timePerItem = (currentTime - startTime) / i;
        final int itemsLeft = items - i;
        final long timeLeftMillis = itemsLeft * timePerItem;
        final long seconds = timeLeftMillis / 1000L % 60L;
        final long minutes = timeLeftMillis / 1000L / 60L % 60L;
        final long hours = timeLeftMillis / 1000L / 3600L % 60L;
        eta = String.format("%02d:%02d:%02d", hours, minutes, seconds);
      }
      printProgress((int) percent, i, items, eta);
      try {
        Thread.sleep(secPerItem[random.nextInt(secPerItem.length)] * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private static void printProgress(
      final int percent, final int itemsDone, final int itemsTotal, final String eta) {
    final StringBuilder string = new StringBuilder(140);
    string
        .append('\r')
        .append(String.format(" %3d%% [", percent))
        .append(String.join("", Collections.nCopies(percent, "=")))
        .append('>')
        .append(String.join("", Collections.nCopies(100 - percent, " ")))
        .append(']')
        .append(String.format(" %3d/%3d, ETA: %s", itemsDone, itemsTotal, eta));
    System.out.print(string);
  }
}
