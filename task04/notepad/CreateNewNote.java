package by.training.task04.notepad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateNewNote {

    public CreateNewNote() throws NullPointerException, IOException, InputMismatchException {

        Scanner scanner = new Scanner(System.in);
        NotepadArray notepadArray = new NotepadArray();

        boolean exit = false;
        System.out.println("Выберите следующие действие:");

        while (!exit) {
            int i = 6;
            System.out.println("----------------------------");
            System.out.println("1 - добавить новую запись");
            System.out.println("2 - удалить запись");
            System.out.println("3 - показать запись в блокноте по дате");
            System.out.println("4 - показать запись в блокноте по содержанию");
            System.out.println("5 - показать все записи в блокноте");
            System.out.println("6 - выход");
            System.out.println("----------------------------");

            try {

                i = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод!");
            }

            switch (i) {
                case 1:
                    System.out.print("Введите новую запись: >");
                    notepadArray.addNote();
                    break;

                case 2:
                    try {
                        RemoveNote.removeNote();
                    } catch (FileNotFoundException e) {
                        System.out.println("Блокнот еще не создан!");
                    }
                    break;

                case 3:
                    try {
                        PrintNotePad.printNoteByDate();
                    } catch (FileNotFoundException e) {
                        System.out.println("Блокнот еще не создан!");
                    } catch (IOException e) {

                    }
                    break;

                case 4:
                    try {
                        PrintNotePad.printNoteByContent();
                    } catch (FileNotFoundException e) {
                        System.out.println("Блокнот еще не создан!");
                    } catch (IOException e) {

                    }
                    break;

                case 5:
                    try {
                        PrintNotePad.printAll();
                    } catch (FileNotFoundException e) {
                        System.out.println("Блокнот еще не создан!");
                    }
                    break;

                case 6:
                    System.out.println("Выполнен выход из приложения!");
                    exit = true;
                    break;
            }

        }
    }

}
