package com.izec.domeins;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="polls")
public class Poll {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate finish;
    private boolean isCompleted;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public Poll(String description, String title, User author) {
        this.description = description;
        this.title = title;
        this.user = author;
        this.start = LocalDate.now();
    }

    public Poll() {

    }

    public String getAuthorName(){
        return user != null? user.getName() : "<none>";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String text) {
        this.description = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tag) {
        this.title = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    public LocalDate getStart() {
        return start;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
