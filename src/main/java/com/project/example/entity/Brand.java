package com.project.example.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @Column(name = "brand_id")
    private String brandId;

    @Column(name = "brand_name")
    private String brandName;

    @ManyToMany(mappedBy = "brand",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Category> category;

}
