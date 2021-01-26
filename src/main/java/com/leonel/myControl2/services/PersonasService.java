package com.leonel.myControl2.services;

import java.util.List;
import java.util.Optional;

import com.leonel.myControl2.models.Personas;
import com.leonel.myControl2.models.PersonasDTO;
import com.leonel.myControl2.repositories.DepartamentosRepository;
import com.leonel.myControl2.repositories.PersonasRepository;


import org.springframework.stereotype.Service;

@Service
public class PersonasService {
    private final PersonasRepository personasRepository;
    private final DepartamentosRepository departamentosRepository;
	public PersonasService(PersonasRepository personasRepository, DepartamentosRepository departamentosRepository) {
        this.personasRepository = personasRepository;
        this.departamentosRepository=departamentosRepository;
	}

  public List<Personas> allPersonas(){
      return personasRepository.findAll();
  }

    public Personas createPersonas(PersonasDTO personas){
        Personas per = new Personas();
        per.setNombre(personas.getNombre());
        per.setApellido(personas.getApellido());
        per.setRut(personas.getRut());
        per.setFechaNacimiento(personas.getFechaNacimiento());
        per.setResideEn(departamentosRepository.findById(personas.getResideEn()).get());
        return personasRepository.save(per);
    }
    public Personas findPersonas(Long id){
        Optional<Personas> optionalPersonas = personasRepository.findById(id);
        if( optionalPersonas.isPresent()){
            return optionalPersonas.get();
        }else{
            return null;
        }
    }
    public Personas updatePersonas(Personas personas){
        return personasRepository.save(personas);
    }

    public void deletePersonas(Long id){
        personasRepository.deleteById(id);
    }
}
