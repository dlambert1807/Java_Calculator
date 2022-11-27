package com.company;
import java.util.Scanner;

// Given an input in the form 'a + b + c' (or '/*-') for number 1-10, calculates the output.
public class Calculator {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter equation:");
        String equation = myObj.nextLine();
        Parser.checkInput(equation);

        String[] calc;
        calc = Parser.inputToArray(equation);
        int finalAns = arrayCalc(calc);
        System.out.println("Output:");
        System.out.println(finalAns);
    }

    //Takes an array of Strings and turns them into integers and characters that can be used in equations.
    public static int arrayCalc(String[] calc) {
        int ans;
        int num1 = Integer.parseInt(calc[0]);
        char symb1 = calc[1].charAt(0);
        int num2 = Integer.parseInt(calc[2]);
        char symb2 = '+';
        int num3 = 0;

        if (num1 > 10 || num2 > 10 || num1 < 1 || num2 < 1) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10");
        }

        if (calc[3] != null) {
            symb2 = calc[3].charAt(0);
            num3 = Integer.parseInt(calc[4]);
            if (num3 > 10 || num3 < 1) {
                throw new IllegalArgumentException("Numbers must be between 1 and 10");
            }
        }

        // For PEMDAS, the second half of the equation will be done first.
        if (symb2 == '*' || symb2 == '/') {
            ans = mdas(num2, symb2, num3);
            ans = mdas(num1, symb1, ans);
        } else {
            ans = mdas(num1, symb1, num2);
            ans = mdas(ans, symb2, num3);
        }

        return ans;
    }

    // Performs multiplication, division, addition or subtraction based on the character argument.
    public static int mdas(int num1, char symb, int num2) {

        switch (symb) {
            case '+':
                return num1 + num2;
            case '*':
                return num1 * num2;
            case '-':
                return num1 - num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }
}
