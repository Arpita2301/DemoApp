package com.project.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "question_answers")
public class QuestionAnswer {

    @Id
    @Column(name = "q_id")
    private String qId;

    @Column(name = "description")
    private String description;

//    @Lob
//    @Column(name = "img")
//    private byte[] img;

    @Column(name = "f_option")
    private String fOption;

    @Column(name = "s_option")
    private String sOption;

    public QuestionAnswer(String description, String fOption, String sOption){

        this.description = description;
        this.fOption  = fOption;
        this.sOption = sOption;
    }
    public QuestionAnswer(){

    }

}
