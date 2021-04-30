package com.project.example.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "c_id")
    private String cId;

    @Column(name = "c_name")
    private String cName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @JoinTable(name = "category_brand_mapping",joinColumns = { @JoinColumn(name = "c_id")},
                                              inverseJoinColumns = { @JoinColumn(name = "brand_id")})
    private List<Brand> brand;



}
