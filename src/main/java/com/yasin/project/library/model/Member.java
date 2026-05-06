package com.yasin.project.library.model;
import java.io.Serializable;
public class Member implements Serializable {
    private String id;
    private String name;
    private String email;

    public Member(String id, String name, String email) {
        this.id = id; this.name = name; this.email = email;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
