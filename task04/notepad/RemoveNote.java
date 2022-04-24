package by.training.task04.notepad;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveNote {

    private static final ArrayList list = new ArrayList();

    public static void removeNote() throws IOException, InputMismatchException {

        copyIntoList();

        int i = 3;

        boolean exit = false;

        while (!exit) {

            System.out.println("Если хотите удалить запись по дате введите> 1");
            System.out.println("Если хотите удалить запись по содержанию введите> 2");
            System.out.println("Если хотите отменить удаление введите> 3");
            System.out.print("> ");

            Scanner scanner = new Scanner(System.in);
            try {

                i = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод!");
            }

            switch (i) {
                case (1) -> {
                    System.out.print("Введите дату в формате yyyy-mm-dd >");
                    Scanner scan1 = new Scanner(System.in);
                    if (scan1.hasNextLine()) {
                        String str1 = scan1.nextLine();
                        if (str1.equals("") || str1.equals(" ")) {
                            break;
                        } else {
                            removeNoteTheList(str1);
                        }
                    }
                    exit = true;
                }
                case (2) -> {
                    System.out.print("Введите содержимое текста:>");
                    Scanner scan2 = new Scanner(System.in);
                    if (scan2.hasNextLine()) {
                        try {
                            String str2 = scan2.nextLine();
                            if (str2.trim().equals("") || str2.equals(" ")) {
                                System.out.println("Вы ничего не ввели!");
                                break;
                            } else {
                                removeNoteTheList(str2.trim());
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Несоответствия ввода!");
                        }
                    }
                    exit = true;
                }
                case (3) -> {
                    System.out.println("Удаление отменено!");
                    exit = true;
                }
            }
        }
    }

    // удаляем строку из массива
    private static void removeNoteTheList(String str) throws IOException {

        boolean exit = false;

        while (!exit) {

            for (int i = 0; i < list.size(); i++) {

                String st = list.get(i).toString();

                if (st.contains(str)) {
                    for (int j = 0; j < list.size(); j++) {
                        String s = list.get(j).toString();

                        if (s.contains(str)) {
                            list.remove(j);
                        }
                    }
                    i = 0;
                } else {
                    exit = true;
                }
            }

        }
        System.out.println("Запись удалена из блокнота!");
        writeFromListTheNotepad();
    }

    //записываем из массива в файл
    private static void writeFromListTheNotepad() throws IOException {

        boolean exit = NotepadArray.file.delete();

        if (exit) {

            File file = new File("d:\\java\\notepad.txt");
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));

            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i));
            }
            pw.close();
        } else {
            writeFromListTheNotepad();
        }

        clearTheList();
    }

    private static void copyIntoList() throws IOException {

        FileReader fl = new FileReader(NotepadArray.getFile());
        Scanner sc = new Scanner(fl);

        while (sc.hasNextLine()) {

            list.add(sc.nextLine());
        }

        fl.close();

    }

    private static void clearTheList() {

        boolean exit = list.removeAll(list);

        if (exit) {

        } else {
            clearTheList();
        }

    }

}
