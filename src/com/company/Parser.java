package com.company;

public class Parser {
    public static void main(String[] args) {
    }

    // Checks some possible errors in the input.
    public static void checkInput(String input) {
        if (input.length() < 5 || input.length() > 12) {
            throw new IllegalArgumentException("Invalid equation inputted.");
        }

        int spaces = 0;
        int symbols = 0;
        int numbers = 0;
        String checkSymbols = "+/*-";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                numbers++;
            } else if (input.charAt(i) == ' ') {
                spaces ++;
            } else if (checkSymbols.indexOf(input.charAt(i)) != -1) {
                symbols ++;
            } else {
                throw new IllegalArgumentException("Invalid character(s) inputted.");
            }
        }

        if (spaces > 4 || spaces < 2 || numbers < 2 || numbers > 6 || symbols < 1 || symbols > 2) {
            throw new IllegalArgumentException("Invalid input.");
        }
    }

    // Converts the input into a String array to more easily calculate the answer.
    // Assumption: Input contains only numbers separated by symbols +, -, /, *
    public static String[] inputToArray(String input) {
        String[] ans = new String[5];
        int index = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                index ++;
            } else {
                ans[index] =  (ans[index] == null ? "" : ans[index]) + input.charAt(i);
            }
        }
        return ans;
    }
}
