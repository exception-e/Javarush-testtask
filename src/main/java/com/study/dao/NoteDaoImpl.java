package com.study.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.study.model.Note;

@Repository
public class NoteDaoImpl implements NoteDao {
    @Autowired
    private SessionFactory sessionFactory;
    private int count;
    private int notesPerPage = 15;

    public NoteDaoImpl() {
    }

    public void addNote(Note note) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(note);
    }

    private Query getQuery(String filter, String order) {
        Query query;
        if(filter.equals("Done")) {

            query = this.sessionFactory.getCurrentSession().createQuery("from Note as Note where Note.done = ? order by Note.createdAt " + order );
            query.setBoolean(0, true);
            System.out.println(query.toString());
        }

        else  if (filter.equals("NotDone"))
        {
            query = this.sessionFactory.getCurrentSession().createQuery("from Note as Note where Note.done = ? order by Note.createdAt " + order);
            query.setBoolean(0,false);
        }

        else
            query = this.sessionFactory.getCurrentSession().createQuery("from Note as Note order by Note.createdAt " + order);

        return query;
    }

    public List<Note> getAllNotes(String filter, int page, String order){

        Query query = getQuery(filter, order);
        query.setFirstResult((page - 1) * notesPerPage);
        query.setMaxResults(notesPerPage);

        List<Note> result = query.list();

        this.setCount(filter, order);

        return result;
    }

    public void setCount(String filter, String order)
    {

        Query query = getQuery(filter, order);

        count = query.list().size();

    }

    public int getCount(){
        return count;
    }

    public void deleteNote(Integer noteId) {
        Note note = this.sessionFactory.getCurrentSession().load(Note.class, noteId);
        if (null != note)
            this.sessionFactory.getCurrentSession().delete(note);


    }

    public Note getNote(int noteId) {
        return (Note)this.sessionFactory.getCurrentSession().get(Note.class, noteId);
    }

    public Note updateNote(Note note) {
        this.sessionFactory.getCurrentSession().update(note);
        return note;
    }




}
