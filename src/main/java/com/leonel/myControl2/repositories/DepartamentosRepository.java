package com.leonel.myControl2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import com.leonel.myControl2.models.Departamentos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentosRepository extends CrudRepository<Departamentos, Id>{
    List<Departamentos> findAll();

    Optional<Departamentos> findById(Long id);
    void deleteById(Long id);
}
