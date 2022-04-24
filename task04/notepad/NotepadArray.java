package by.training.task04.notepad;

import java.io.*;
import java.util.Scanner;

public class NotepadArray {

    public static File file = new File("d:\\java\\notepad.txt");

    Scanner scanner = new Scanner(System.in);
    Notepad notepad;

    public static File getFile() {
        return file;
    }

    public void addNote() throws IOException {

        String str = scanner.nextLine();
        notepad = new Notepad(str);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        pw.println(notepad);
        pw.close();
        System.out.println("Запись добавлена в блокнот!");
    }

}

