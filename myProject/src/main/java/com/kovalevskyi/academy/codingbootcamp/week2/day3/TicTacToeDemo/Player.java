package com.kovalevskyi.academy.codingbootcamp.week2.day3.TicTacToeDemo;

import java.util.Scanner;

public class Player { // Объясню название класса-я планировал сделать режим игры Игрок vs PC. Думал
  // создавать объект игрока или компьютера, в зависимости от того, как хочет играть
  // пользователь.
  String coordinate;
  char coordinateX;
  char coordinateY;
  byte moveCounter = 1; // счетчик хода. крестики ходят по четному счетчику

  public byte getMoveCounter() {
    return moveCounter;
  }

  public char[][] update(char gameBoard[][]) {

    if (moveCounter % 2 == 0) {
      System.out.println(
          "\tMove number: "
              + moveCounter
              + ". Player X, your turn. Enter the coordinates of the move (example:a2): ");
    } else {
      System.out.println(
          "\tMove number: "
              + moveCounter
              + ". Player O, your turn. Enter the coordinates of the move (example:a2): ");
    }
    Scanner scan = new Scanner(System.in);

    coordinate = scan.next(); // заполняю строку

    if (coordinate.length() != 2) {
      System.out.println("You entered the wrong move format. Try again.");
      return gameBoard;
    } // если пользователь ввёл неверное количество символов (!=2)

    coordinateX = coordinate.charAt(0);
    coordinateY = coordinate.charAt(1);

    int x = 0;
    int y = 0; // переменные для перевода введенных пользователем символов в числа
    // в ячейку)
    switch (coordinateX) {
      case 'a' -> x = 0;
      case 'b' -> x = 1;
      case 'c' -> x = 2;
      default -> {
        System.out.println("You entered the wrong move format. Try again.");
        return gameBoard; // досрочный выход из ф-ции (чтобы не пойти дальше и не записать х или о
      }
    }
    switch (coordinateY) {
      case '1'-> y = 0;
      case '2'-> y = 1;
      case '3'-> y = 2;
      default -> {
        System.out.println("You entered the wrong move format. Try again.");
        return gameBoard;
        }
    }

    if (gameBoard[x][y] == '-') {
      if ((moveCounter % 2 == 0) && (gameBoard[x][y] != 'x') && (gameBoard[x][y] != 'o')) {
        gameBoard[x][y] = 'x';
      } else {
        gameBoard[x][y] = 'o';
      }
      moveCounter++;
    } else {
      System.out.println("Cell is busy, try again \t");
    }

    return gameBoard;
  }
}
