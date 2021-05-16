package com.project.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="student")

public class Student {
    @Id
    @Column
    private String studId;

    @Column
    private String studName;


    @Column
    private String studRollno;

    @Column
    private String studBranch;


}
