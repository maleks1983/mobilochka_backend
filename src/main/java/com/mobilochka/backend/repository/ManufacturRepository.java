package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Group;
import com.mobilochka.backend.model.product.Manufactur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ManufacturRepository {

    @Autowired
    private ManufacturJpaRepository repository;

    @Transactional
    public Manufactur save(Manufactur manufactur) {
        return repository.save(manufactur);
    }


    public Manufactur findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Manufactur findByName(String name){
        return repository.findByName(name);
    }

    @Transactional
    public Manufactur saveByName(String name) {
        Manufactur manufactur = repository.findByName(name);
        if (manufactur == null) {
            manufactur = repository.save(new Manufactur(name));
        }
        return manufactur;

    }
}

