package by.training.task04.notepad;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintNotePad {

    public static void printAll() throws IOException {

        FileReader fl = new FileReader(NotepadArray.getFile());
        Scanner sc = new Scanner(fl);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        fl.close();
    }

    public static void printNoteByDate() throws FileNotFoundException, IOException {
        FileReader fl = new FileReader(NotepadArray.getFile());
        Scanner sc = new Scanner(fl);

        System.out.print("Введите дату в формате yyyy-mm-dd >");

        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();

        int q = 0;

        if (!str1.equals("")) {
            while (sc.hasNextLine()) {
                String str2 = sc.nextLine();
                if (str2.contains(str1)) {
                    System.out.println(str2);
                    q++;
                }
            }
            if (q == 0) {
                System.out.println("Записи с такой датой нет!");
            }
        } else {
            System.out.println("Вы ничего не ввели!");
            throw new IOException();

        }
    }

    public static void printNoteByContent() throws FileNotFoundException, IOException {

        FileReader fl = new FileReader(NotepadArray.getFile());
        Scanner sc = new Scanner(fl);

        System.out.print("Введите содержимое блокнота >");
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();

        int q = 0;

        if (!str1.equals("")) {
            while (sc.hasNextLine()) {
                String str2 = sc.nextLine();
                if (str2.contains(str1)) {
                    System.out.println(str2);
                    q++;
                }
            }

            if (q == 0) {
                System.out.println("Такой записи нет!");
            }
        } else {
            System.out.println("Вы ничего не ввели!");
            throw new IOException();

        }
    }
}

