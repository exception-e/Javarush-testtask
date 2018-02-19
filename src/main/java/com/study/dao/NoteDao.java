package com.study.dao;

import java.util.List;
import com.study.model.Note;

public interface NoteDao {
    void addNote(Note var1);

    List<Note> getAllNotes(String var1, int page, String order) throws Exception;

    void deleteNote(Integer var1);

    Note updateNote(Note var1);

    Note getNote(int var1);

    int getCount();

    void setCount(String var1, String var2);
}
