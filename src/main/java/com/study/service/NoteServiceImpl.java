package com.study.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.dao.NoteDao;
import com.study.model.Note;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    public NoteServiceImpl() {
    }

    @Transactional
    public void addNote(Note note) {
        this.noteDao.addNote(note);
    }

    @Transactional
    public List<Note> getAllNotes(String filter, int page, String order) throws Exception {
        return this.noteDao.getAllNotes(filter, page, order);
    }

    @Transactional
    public int getCount(){
        return this.noteDao.getCount();
    }


    @Transactional
    public void deleteNote(Integer id) {
        this.noteDao.deleteNote(id);
    }

    public Note getNote(int id) {
        return this.noteDao.getNote(id);
    }

    public Note updateNote(Note note) {
        return this.noteDao.updateNote(note);
    }
}