package com.project.example.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;

@Entity
@Table(name="student")

public class Student {
    @Id
    @Column
    private String stud_id;

    @Column
    private String stud_name;


    @Column
    private String stud_rollno;

    @Column
    private String stud_branch;




    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public String getStud_rollno() {
        return stud_rollno;
    }

    public void setStud_rollno(String stud_rollno) {
        this.stud_rollno = stud_rollno;
    }


    public String getStud_branch() {
        return stud_branch;
    }

    public void setStud_branch(String stud_branch) {
        this.stud_branch = stud_branch;
    }


}
