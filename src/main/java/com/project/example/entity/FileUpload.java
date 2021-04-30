package com.project.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "file_upload")
public class FileUpload {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "f_id")
    private String fId;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "f_type")
    private String fType;

    @Lob
    @Column(name = "f_data")
    private byte[] fData;

    public FileUpload(String fName, String fType, byte[] fData){

        this.fName = fName;
        this.fType = fType;
        this.fData  = fData;

    }

    public FileUpload(){

    }

}
