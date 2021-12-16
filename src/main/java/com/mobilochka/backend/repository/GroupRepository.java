package com.mobilochka.backend.repository;

import com.mobilochka.backend.model.product.Category;
import com.mobilochka.backend.model.product.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GroupRepository {

    @Autowired
    private GroupJpaRepository repository;

    @Transactional
    public Group save(Group group) {
        return repository.save(group);
    }


    public Group findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Group findByName(String name){
        return repository.findByName(name);
    }

    @Transactional
    public Group saveByName(String name) {
        Group group = repository.findByName(name);
        if (group == null) {
            group = repository.save(new Group(name));
        }
        return group;

    }

}

