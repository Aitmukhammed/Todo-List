package com.company.test.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contentText;
    private boolean completed;

    public Todo(Long id, String title, String contentText, boolean completed) {
        this.id = id;
        this.title = title;
        this.contentText = contentText;
        this.completed = completed;
    }

    public Todo() {
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
