package com.kovalevskyi.academy.codingbootcamp.week2.day3.TicTacToeDemo;

public class Main {
  static boolean gameFinished = false;
  static final char[][] board =
      new char[][] {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
      }; // объявляю массив символов размерности 3 на 3

  public static void main(String[] args) {
    Player playerGame = new Player();
    byte moveOfPlayers = 1;
    while (!gameFinished) { // пока игра не закончилась - играем

      playerGame.update(board);
      moveOfPlayers = playerGame.getMoveCounter();
      if (moveOfPlayers > 9) {
        gameFinished = true;
      } // ходов больше нет - ничья
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {

          if (moveOfPlayers > 5) { // до победы надо минимум 5 ходов. нет смысла проверять раньше

            if ((board[0][0] == board[0][1])
                && (board[0][1] == board[0][2])
                && (board[0][0] != '-')) {
              gameFinished = true;
            }
            if ((board[1][0] == board[1][1])
                && (board[1][1] == board[1][2])
                && (board[1][1] != '-')) {
              gameFinished = true;
            }
            if ((board[2][0] == board[2][1])
                && (board[2][1] == board[2][2])
                && (board[2][2] != '-')) {
              gameFinished = true;
            } // проверка на победу по горизонтали

            if ((board[0][0] == board[1][0])
                && (board[1][0] == board[2][0])
                && (board[0][0] != '-')) {
              gameFinished = true;
            }
            if ((board[0][1] == board[1][1])
                && (board[1][1] == board[2][1])
                && (board[1][1] != '-')) {
              gameFinished = true;
            }
            if ((board[0][2] == board[1][2])
                && (board[1][2] == board[2][2])
                && (board[2][2] != '-')) {
              gameFinished = true;
            } // проверка на победу по вертикали

            if ((board[0][0] == board[1][1])
                && (board[1][1] == board[2][2])
                && (board[2][2] != '-')) {
              gameFinished = true;
            }
            if ((board[0][2] == board[1][1])
                && (board[1][1] == board[2][0])
                && (board[2][0] != '-')) {
              gameFinished = true;
            } // проверка на победу по диагонали
          }

          System.out.print(board[i][j] + "\t"); // вывод элемента+отступ
        }
        System.out.println(); // переход на новую строку для создания сетки игры
      }
    }

    if (moveOfPlayers < 9) {
      if (moveOfPlayers % 2 == 0) {
        System.out.println("Player O won, congratulations!");
      } else {
        System.out.println("Player X won, congratulations!");
      }
    } else {
      System.out.println("Draw!");
    }
    System.out.println("Game over!");
  }
}
