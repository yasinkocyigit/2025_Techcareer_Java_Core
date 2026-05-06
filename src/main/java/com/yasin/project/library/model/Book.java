package com.yasin.project.library.model;
import java.io.Serializable;
public class Book implements Serializable {
    private String id;
    private String title;
    private String author;
    private BookCategory category;
    private boolean isAvailable;

    public Book(String id, String title, String author, BookCategory category, boolean isAvailable) {
        this.id = id; this.title = title; this.author = author; this.category = category; this.isAvailable = isAvailable;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public BookCategory getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}
