package com.leonel.myControl2.services;

import java.util.List;
import java.util.Optional;

import com.leonel.myControl2.models.Personas;
import com.leonel.myControl2.repositories.PersonasRepository;


import org.springframework.stereotype.Service;

@Service
public class PersonasService {
    private final PersonasRepository personasRepository;

	public PersonasService(PersonasRepository personasRepository) {
		this.personasRepository = personasRepository;
	}

  public List<Personas> allPersonas(){
      return personasRepository.findAll();
  }

    public Personas createPersonas(Personas personas){
        return personasRepository.save(personas);
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
