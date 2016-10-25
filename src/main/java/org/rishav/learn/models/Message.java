package org.rishav.learn.models;

import java.util.Date;

public class Message {

    private String content;
    private Date created;
    private String author;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", created=" + created +
                ", author='" + author + '\'' +
                '}';
    }
}
