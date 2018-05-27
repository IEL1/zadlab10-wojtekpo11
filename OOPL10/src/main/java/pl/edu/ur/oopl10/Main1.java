/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.ur.oopl10;

/**
 *
 * @author Wojciech
 */
import java.util.Scanner;

public class Main1 extends java.lang.Exception {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dzielna = scanner.nextInt();
        int dzielnik = scanner.nextInt();

        try {

            int wynik = dzielna / dzielnik;
            System.out.println("Niemożliwe!");
        } catch (ArithmeticException e) {
            System.out.print("Niepoprawna dzielna.");

        }

    }
}
