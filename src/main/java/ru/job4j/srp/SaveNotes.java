package ru.job4j.srp;

import java.util.Date;

/**
 * The interface SaveNotes.
 * В интерфесе SaveNotes помимо метода saveNote установлены методы addPhoto() и setDate(Date date)
 * они должны быть выделены в отдельные интерфейсы, чтобы не нарушать принципы sr
 */
public interface SaveNotes {
    void saveNote();
    void addPhoto();
    void setDate(Date date);
}