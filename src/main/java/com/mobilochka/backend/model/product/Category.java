package com.mobilochka.backend.model.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilochka.backend.model.AbstractIdEntyty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category extends AbstractIdEntyty {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @JsonIgnore
    private Set<Product> productList;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
