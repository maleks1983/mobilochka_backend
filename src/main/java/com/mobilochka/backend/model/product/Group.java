package com.mobilochka.backend.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mobilochka.backend.model.AbstractIdEntyty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends AbstractIdEntyty {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @JsonIgnore
    protected Set<Product> productList;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Group(String name) {
        this.name = name;
    }

    @Override
    public boolean isNew() {
        return false;
    }

}
