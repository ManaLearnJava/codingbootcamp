package com.kovalevskyi.academy.codingbootcamp.week0.day1;

class Alphabet {

  public static char[] generateAlphabet() {
    char[] alphabet = new char[26];
    for (int i = 0; i < 26; i++) {
      alphabet[i] = (char) (97 + i);
    }
    return alphabet;
  }

  public static char[] generateReversedAlphabet() {
    char[] reverseAlphabet = new char[26];
    for (int i = 0; i < 26; i++) {
      reverseAlphabet[i] = (char) (122 - i);
    }
    return reverseAlphabet;
  }
}
