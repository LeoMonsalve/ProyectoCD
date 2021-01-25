package com.leonel.myControl2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import com.leonel.myControl2.models.Edificios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificiosRepository extends CrudRepository<Edificios, Id> {
    List<Edificios> findAll();

    Optional<Edificios> findById(Long id);
    void deleteById(Long id);
}
