package com.Mindpoint.domain;

import javax.persistence.*;

@Entity //говорит спрингу что это сущность которую надо сохранять в БД
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER) //указываем БД что одному пользователю соотвествует множество сообщений
    @JoinColumn(name = "user_id") //что бы поле называлось user_id
    private User author;

    public Message() { // Necessarily
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public String getAuthorName() { //проверяем есть ли автор в БД
        return author != null ? author.getUsername() : "<none>";

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
