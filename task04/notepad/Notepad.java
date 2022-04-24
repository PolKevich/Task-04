package by.training.task04.notepad;

import java.time.LocalDate;
import java.util.Objects;

public class Notepad {

    private final String date;
    private final String text;

    public Notepad(String text) throws NullPointerException {

        this.date = Notepad.date();
        this.text = text;

    }

    public static String date() {
        LocalDate d = LocalDate.now();
        return d.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Notepad notepad = (Notepad) o;
        return date.equals(notepad.date) && text.equals(notepad.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, text);
    }

    @Override
    public String toString() {
        return "дата записи: " + date + " " + "запись: " + text;
    }

}
