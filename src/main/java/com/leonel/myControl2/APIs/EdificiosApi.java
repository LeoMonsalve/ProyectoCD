package com.leonel.myControl2.APIs;

import java.util.List;

import com.leonel.myControl2.models.Edificios;
import com.leonel.myControl2.services.EdificiosService;

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
@RequestMapping("api/edificios")
public class EdificiosApi {
    
    @Autowired
    private EdificiosService edificiosService;
    @GetMapping
    public List<Edificios> index(){
        return edificiosService.allEdificios();
    }
    @GetMapping("/{id}")
    public Edificios mostrarPorId(@PathVariable Long id){
        return edificiosService.findEdificios(id);
    }
    @PostMapping
    public Edificios creaEdificios(@RequestBody Edificios edificios)  {
        return edificiosService.createEdificios(edificios);
    }  
    @PutMapping("/{id}")
    public Edificios update(@RequestBody Edificios edificios, @PathVariable Long id){
        Edificios edificios2 = edificiosService.findEdificios(id);

        edificios2.setNombreEdificio(edificios.getNombreEdificio());
        edificios2.setDireccion(edificios.getDireccion());
        edificios2.setRut(edificios.getRut());
        edificios2.setDepartamentos(edificios.getDepartamentos());

        return edificiosService.updatEdificios(edificios);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        edificiosService.deleteEdificios(id);
    }
}
