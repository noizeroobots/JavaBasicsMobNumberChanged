package com.company;

import java.util.Scanner;
import java.io.*;
public class Main {


    public static void main(String[] args) {
        System.out.print("Your number: ");
        Scanner number1 = new Scanner(System.in);
        String number = number1.nextLine();
        String[] result = validatePhoneNumber(number);
        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    private static String[] validatePhoneNumber(String number) {
        String out = "";
        String changedout = "";

        if (number.length() >= 2 && number.charAt(0) == '+' && number.charAt(1) == '7') {
            number = "8" + number.substring(2, number.length());
            changedout += "Changed +7 to 8.\n";
        }

        boolean flag = false;

        for (int i = 0; i < number.length(); ++i) {

            if (number.charAt(i) == '(') {
                number = number.substring(0, i) + number.substring(i + 1, number.length());
                --i;
                flag = true;
            }
            if (number.charAt(i) == ')') {
                number = number.substring(0, i) + number.substring(i + 1, number.length());
                --i;
                flag = true;
            }
            if (number.charAt(i) == ' ') {
                number = number.substring(0, i) + number.substring(i + 1, number.length());
                --i;
                flag = true;
            }
        }

        if (flag) {
            changedout += "Spaces or parenthesis were erased.";
        }

        if (out.length() == 0) {
            changedout += "You made no changes!";
        }

        if (number.length() != 11) {
            changedout += "You has entered an incorrect number!";
        }

        String[] result = new String[2];
        result[0] = out;
        result[1] = changedout;
        return result;
    }

}