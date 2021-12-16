package com.mobilochka.backend.model.product;

import com.mobilochka.backend.model.AbstractIdEntyty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "manufacture")
public class Manufactur extends AbstractIdEntyty {
    @Column(name = "manufacture_name")
    private String name;

    @Override
    public boolean isNew() {
        return false;
    }
}
