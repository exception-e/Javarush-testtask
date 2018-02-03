package com.study.model;


import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
        name = "todos",
        schema = "test1"
)

public class Todo {
    private int id;
    private Timestamp createdAt;
    private String todo;
    private boolean done;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date todoD;

    public Todo() {
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
            name = "todo"
    )
    public String getTodo() {
        return this.todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
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
        return "Todo{id=" + this.id + ", createdAt=" + this.createdAt + ", todo='" + this.todo + '\'' + ", done=" + this.done + ", todoD=" + this.todoD+"'}'" ;
    }


    @Temporal(TemporalType.DATE)
    @Column(
            name = "todoD"
    )
    public Date getTodoD() {
        return this.todoD;
    }

    public void setTodoD(Date todoD) {
        this.todoD = todoD;
    }





    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (o != null && this.getClass() == o.getClass())

        {
            Todo that = (Todo)o;

            if (this.id != that.id)
                return false;

            if (this.done != that.done)
                return false;

            if (this.createdAt != null ? !this.createdAt.equals(that.createdAt) : that.createdAt != null)
                return false;

            if (this.todo != null ? !todo.equals(that.todo) : that.todo !=null)
                return false;

            if (this.todoD != null ? !this.todoD.equals(that.todoD) : that.todoD != null)
                return false;
        }
            return true;

    }

    public int hashCode() {
        int result = this.id;
        result = 31 * result + (this.createdAt != null ? this.createdAt.hashCode() : 0);
        result = 31 * result + (this.todo != null ? this.todo.hashCode() : 0);
        return result;
    }
}
