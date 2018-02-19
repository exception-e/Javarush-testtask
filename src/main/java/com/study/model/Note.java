package com.study.model;


import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
        name = "notes",
        schema = "test"
)

public class Note {
    private int id;
    private Timestamp createdAt;
    private String note;
    private boolean done;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date noteD;

    public Note() {
    }

    @Id
    @Column(
            name = "id"
    )
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(
            name = "created_at"
    )
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(
            name = "note"
    )
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(
            name = "done"
    )
    public boolean getDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String toString() {
        return "Note{id=" + this.id + ", createdAt=" + this.createdAt + ", note='" + this.note + '\'' + ", done=" + this.done + ", noteD=" + this.noteD +"'}'" ;
    }


    @Temporal(TemporalType.DATE)
    @Column(
            name = "noteD"
    )
    public Date getNoteD() {
        return this.noteD;
    }

    public void setNoteD(Date noteD) {
        this.noteD = noteD;
    }





    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o != null && this.getClass() == o.getClass())

        {
            Note that = (Note)o;

            if (this.id != that.id)
                return false;

            if (this.done != that.done)
                return false;

            if (this.createdAt != null ? !this.createdAt.equals(that.createdAt) : that.createdAt != null)
                return false;

            if (this.note != null ? !note.equals(that.note) : that.note !=null)
                return false;

            if (this.noteD != null ? !this.noteD.equals(that.noteD) : that.noteD != null)
                return false;
        }
            return true;

    }

    public int hashCode() {
        int result = this.id;
        result = 31 * result + (this.createdAt != null ? this.createdAt.hashCode() : 0);
        result = 31 * result + (this.note != null ? this.note.hashCode() : 0);
        return result;
    }
}
