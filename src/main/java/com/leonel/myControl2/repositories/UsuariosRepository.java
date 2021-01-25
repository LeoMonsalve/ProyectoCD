package com.leonel.myControl2.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import com.leonel.myControl2.models.Usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Id> {
    List<Usuarios> findAll();

    Optional<Usuarios> findById(Long id);
    void deleteById(Long id);
}
