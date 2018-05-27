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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WprowadzZKonsoli {

    public static void main(String[] args) {

        System.out.println("Wprowadz numer operacji \n----------------");
        System.out.println("1 - operacje na INT\n"
                + "2 - operacje na String\n"
                + "3 - operacje na Char\n"
                + "4 - wyjście\n");
        Scanner scanner = new Scanner(System.in);
        int numer = scanner.nextInt();
        switch (numer) {
            case 1:
                int liczba = WprowadzInt();
                System.out.println("Wprowadziles liczbe: " + liczba);
                ZapisDoPliku(String.valueOf(liczba), "int.txt");
                OdczytInt();
                break;
            case 2:
                String tekst = WprowadzString();
                System.out.println("Wprowadziles tekst: " + tekst);
                ZapisDoPliku(tekst, "tekst.txt");
                OdczytString();
                break;
            case 3:
                char znak = WprowadzChar();
                System.out.println("Wprowadziles znak: " + znak);
                ZapisDoPliku(String.valueOf(znak), "char.txt");
                OdczytChar();
                break;
            case 4:
                System.exit(0);
                break;
        }

    }

    public static int WprowadzInt() {
        try {
            System.out.println("Wprowadz liczbę");
            Scanner scanner = new Scanner(System.in);
            int liczba = scanner.nextInt();
            return liczba;
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzona wartość nie jest intem");
            return 0;
        } catch (Exception e) {
            System.out.println("Błąd podczas wprowadzania liczby: " + e.getMessage());
            return 0;
        }
    }

    public static String WprowadzString() {
        try {
            System.out.println("Wprowadz tekst");
            Scanner scanner = new Scanner(System.in);
            String tekst = scanner.next();
            return tekst;
        } catch (Exception e) {
            System.out.println("Błąd podczas wprowadzania tekstu: " + e.getMessage());
            return "";
        }

    }

    public static char WprowadzChar() {
        try {
            System.out.println("Wprowadz znak");
            Scanner scanner = new Scanner(System.in);
            String tekst = scanner.next();
            if (tekst.length() != 1) {
                throw new Exception("Niepoprawna dlugosc wprowadzonego znaku");
            }
            char znak = tekst.charAt(0);
            return znak;
        } catch (Exception e) {
            System.out.println("Błąd podczas wprowadzania znaku: " + e.getMessage());
            return 0;
        }

    }

    public static void ZapisDoPliku(String tekst, String nazwa_pliku) {
        try {
            FileWriter fwo = new FileWriter(nazwa_pliku, true);
            BufferedWriter bwo = new BufferedWriter(fwo);
            bwo.write(tekst);
            bwo.newLine();
            bwo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd wejscia/wyjscia ");
        }

    }

    public static void OdczytInt() {
        try {
            FileReader fr = new FileReader("int.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead;
            System.out.println("Odczytane liczb pliku: ");
            while ((stringRead = br.readLine()) != null) {
                int liczba = Integer.parseInt(stringRead);
                System.out.println(liczba);

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd wejscia/wyjscia ");
        } catch (NumberFormatException e) {
            System.out.println("Plik zawiera niepoprawny typ danych");
        }
    }

    public static void OdczytString() {
        try {
            FileReader fr = new FileReader("tekst.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead;
            System.out.println("Odczytane tekstu z pliku: ");
            while ((stringRead = br.readLine()) != null) {
                System.out.println(stringRead);

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd wejscia/wyjscia ");
        } catch (NumberFormatException e) {
            System.out.println("Plik zawiera niepoprawny typ danych");
        }
    }

    public static void OdczytChar() {
        try {
            FileReader fr = new FileReader("char.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead;
            System.out.println("Odczytane znaku z pliku: ");
            while ((stringRead = br.readLine()) != null) {
                char znak = stringRead.charAt(0);
                System.out.println(stringRead);

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku");
        } catch (IOException e) {
            System.out.println("Błąd wejscia/wyjscia ");
        } catch (NumberFormatException e) {
            System.out.println("Plik zawiera niepoprawny typ danych");
        }
    }

}
