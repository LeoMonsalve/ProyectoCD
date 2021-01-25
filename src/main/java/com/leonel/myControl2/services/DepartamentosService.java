package com.leonel.myControl2.services;

import java.util.List;
import java.util.Optional;

import com.leonel.myControl2.models.Departamentos;
import com.leonel.myControl2.repositories.DepartamentosRepository;

import org.springframework.stereotype.Service;

@Service
public class DepartamentosService {
    private final DepartamentosRepository departamentosRepository;

	public DepartamentosService(DepartamentosRepository departamentosRepository) {
		this.departamentosRepository= departamentosRepository;
	}

  public List<Departamentos> allDepartamentos(){
      return departamentosRepository.findAll();
  }

    public Departamentos createDeparmentos(Departamentos departamentos){
        return departamentosRepository.save(departamentos);
    }
    public Departamentos findDepartamentos(Long id){
        Optional<Departamentos> optionalDepartamentos = departamentosRepository.findById(id);
        if( optionalDepartamentos.isPresent()){
            return optionalDepartamentos.get();
        }else{
            return null;
        }
    }
    public Departamentos updatedDepartamentos(Departamentos departamentos){
        return departamentosRepository.save(departamentos);
    }

    public void deleteDepartamentos(Long id){
        departamentosRepository.deleteById(id);
    }
}
