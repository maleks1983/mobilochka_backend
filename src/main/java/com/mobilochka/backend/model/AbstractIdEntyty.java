package com.mobilochka.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Access(AccessType.FIELD)
public abstract class AbstractIdEntyty implements Persistable<Long> {
    public static final int START_SEQ = 100000;
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Long id;

    @Override
    public String toString() {
        return "id=" + id;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return false;
    }
}
