package by.training.task04.notepad;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class NotepadTest {

    @Test
    public void getFile() {

        File expected = NotepadArray.getFile();

        File actual = new File("d:\\java\\notepad.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addNote() throws IOException {

        FileReader fl = new FileReader(NotepadArray.getFile());
        Scanner sc = new Scanner(fl);
        String expected = null;

        // формат записи в блокноте
        String actual = "дата записи: 2022-04-23 запись: запись номер 10";

        while (sc.hasNextLine()) {

            String str = sc.nextLine();

            if (str.equals(actual)) {

                expected = str;
                fl.close();
            }

        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllNotesNoNull() throws IOException {

        ArrayList expected = new ArrayList();

        FileReader fl = new FileReader(NotepadArray.getFile());
        Scanner sc = new Scanner(fl);

        while (sc.hasNextLine()) {

            expected.add(sc.nextLine());
        }

        fl.close();

        Assert.assertNotNull(expected);

    }

    @Test
    public void date(){

        String expected = Notepad.date();

        LocalDate date = LocalDate.now();

        String actual = date.toString();

        Assert.assertEquals(expected, actual);
    }
}