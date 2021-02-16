package com.kovalevskyi.academy.codingbootcamp.week2.day2.ProgressBarDemo;

import java.awt.*;
import javax.swing.*;

public class ProgressBarDemo {
  JFrame frame = new JFrame();
  JProgressBar bar = new JProgressBar();

  ProgressBarDemo() {
    bar.setValue(0);
    bar.setBounds(0, 0, 320, 50);
    bar.setStringPainted(true);
    bar.setFont(new Font("MV Boli", Font.BOLD, 33));
    bar.setForeground(Color.BLACK);
    bar.setBackground(Color.WHITE);

    frame.add(bar);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(320, 88);
    frame.setLayout(null);
    frame.setVisible(true);

    fill();
  }

  public void fill() {
    int count = 0;
    while (count <= 100) {
      bar.setValue(count);
      try {
        Thread.sleep(77);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      count += 3;
      if (count > 95 && count <= 100) {
        count += 100 - count;
      }
    }
    bar.setString("Done !");
  }
}
