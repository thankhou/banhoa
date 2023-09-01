package com.poly.asm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;



import lombok.Data;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Data
@javax.persistence.Entity
@Table(name="Categories")
public class Category implements Serializable {
    @Id
    String id;
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<Product> products;
}
