package com.study.service;

import java.util.List;
import com.study.model.Note;

public interface NoteService {
    void addNote(Note var1);

    List<Note> getAllNotes(String var1, int page, String var2) throws Exception;

    int getCount();

    void deleteNote(Integer var1);

    Note getNote(int var1);

    Note updateNote(Note var1);
}
