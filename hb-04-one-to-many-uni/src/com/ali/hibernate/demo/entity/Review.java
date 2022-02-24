package com.ali.hibernate.demo.entity;


import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {


    //1-define fields
    //2-define constructor
    //3-define getter/setter
    //4-define to string
    //5-annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "comment")
    private String comment;


    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
