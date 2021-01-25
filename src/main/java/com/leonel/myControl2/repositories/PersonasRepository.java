package com.leonel.myControl2.repositories;

import java.util.List;


import com.leonel.myControl2.models.Personas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends CrudRepository<Personas, Long> {

    List<Personas> findAll();

    void deleteById(Long id);

    Long deleteByRutStartingWith(String search);
}
