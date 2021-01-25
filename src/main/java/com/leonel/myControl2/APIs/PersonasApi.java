package com.leonel.myControl2.APIs;

import java.util.List;

import com.leonel.myControl2.models.Personas;

import com.leonel.myControl2.services.PersonasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequestMapping("api/personas")
public class PersonasApi {

    @Autowired
    private PersonasService personasService;
    @GetMapping
    public List<Personas> index(){
       return personasService.allPersonas();
    }
    @GetMapping("/{id}")
    public Personas mostrarPorId(@PathVariable Long id){
        return personasService.findPersonas(id);
    }
    @PostMapping
    public Personas crearPersonas(@RequestBody Personas personas)  {
        return personasService.createPersonas(personas);
    }  
    @PutMapping("/{id}")
    public Personas update(@RequestBody Personas personas, @PathVariable Long id){
        Personas personas1 = personasService.findPersonas(id);

        personas1.setNombre(personas.getNombre());
        personas1.setApellido(personas.getApellido());
        personas1.setRut(personas.getRut());
        personas1.setFechaNacimiento(personas.getFechaNacimiento());

        return personasService.updatePersonas(personas);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personasService.deletePersonas(id);
    }
    
}
