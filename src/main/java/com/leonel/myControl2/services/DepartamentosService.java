package com.leonel.myControl2.services;

import java.util.List;
import java.util.Optional;

import com.leonel.myControl2.models.Departamentos;
import com.leonel.myControl2.models.DepartamentosDTO;
import com.leonel.myControl2.repositories.DepartamentosRepository;
import com.leonel.myControl2.repositories.EdificiosRepository;

import org.springframework.stereotype.Service;

@Service
public class DepartamentosService {
    private final DepartamentosRepository departamentosRepository;
    private final EdificiosRepository edificiosRepository;
    public DepartamentosService(DepartamentosRepository departamentosRepository, EdificiosRepository edificiosRepository) {
        this.departamentosRepository= departamentosRepository;
        this.edificiosRepository=edificiosRepository;
    }

  public List<Departamentos> allDepartamentos(){
      return departamentosRepository.findAll();
  }

    public Departamentos createDeparmentos(DepartamentosDTO departamentos){
        Departamentos dep = new Departamentos();
        System.out.println(departamentos.getEdificio());
        dep.setNumero(departamentos.getNumero());
        dep.setEdificios(edificiosRepository.findById(departamentos.getEdificio()).get());
       return departamentosRepository.save(dep);
      
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
