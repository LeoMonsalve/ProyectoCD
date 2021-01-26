package com.leonel.myControl2.APIs;

import java.util.List;

import com.leonel.myControl2.models.Departamentos;
import com.leonel.myControl2.models.DepartamentosDTO;
import com.leonel.myControl2.services.DepartamentosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/departamentos")
public class DepartamentosApi {
    @Autowired
    private DepartamentosService departamentosService;
    @GetMapping
    public List<Departamentos> index(){
        return departamentosService.allDepartamentos();
    }
    @GetMapping("/{id}")
    public Departamentos mostrarPorId(@PathVariable Long id){
        return departamentosService.findDepartamentos(id);
    }
    @PostMapping
    
    public Departamentos crearDepartamentos(@RequestBody DepartamentosDTO departamentos){
        return departamentosService.createDeparmentos(departamentos);
    }
    @PutMapping("/{id}")
    public Departamentos update(@RequestBody Departamentos departamentos, @PathVariable Long id){
        Departamentos departamentos2 = departamentosService.findDepartamentos(id);
        
        departamentos2.setNumero(departamentos.getNumero());
        departamentos2.setPersonas(departamentos.getPersonas());

        return departamentosService.updatedDepartamentos(departamentos);
     }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
       departamentosService.deleteDepartamentos(id);
    }

    
}
