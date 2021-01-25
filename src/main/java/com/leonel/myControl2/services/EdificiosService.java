package com.leonel.myControl2.services;

import java.util.List;
import java.util.Optional;

import com.leonel.myControl2.models.Edificios;
import com.leonel.myControl2.repositories.EdificiosRepository;

import org.springframework.stereotype.Service;

@Service
public class EdificiosService {
    private final EdificiosRepository edificiosRepository;

	public EdificiosService(EdificiosRepository edificiosRepository) {
		this.edificiosRepository=edificiosRepository;
	}

  public List<Edificios> allEdificios(){
      return edificiosRepository.findAll();
  }

    public Edificios createEdificios(Edificios edificios){
        return edificiosRepository.save(edificios);
    }
    public Edificios findEdificios(Long id){
        Optional<Edificios>optionalEdificios = edificiosRepository.findById(id);
        if( optionalEdificios.isPresent()){
            return optionalEdificios.get();
        }else{
            return null;
        }
    }
    public Edificios updatEdificios(Edificios edificios){
        return edificiosRepository.save(edificios);
    }

    public void deleteEdificios(Long id){
        edificiosRepository.deleteById(id);
    }
}
