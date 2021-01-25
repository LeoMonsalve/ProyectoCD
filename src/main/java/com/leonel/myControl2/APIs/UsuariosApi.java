package com.leonel.myControl2.APIs;

import java.util.List;

import com.leonel.myControl2.models.Usuarios;
import com.leonel.myControl2.services.UsuariosService;

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
@RequestMapping("api/usuarios")
public class UsuariosApi {
    @Autowired
    private UsuariosService usuariosService;
    @GetMapping
    public List<Usuarios> index(){
        return usuariosService.allUsuarios();
    }
    @GetMapping("/{id}")
    public Usuarios mostrarPorId(@PathVariable Long id){
        return usuariosService.findUsuarios(id);
    }
    @PostMapping
    public Usuarios creaUsuarios(@RequestBody Usuarios usuarios)  {
        return usuariosService.createdUsuarios(usuarios);
    }  
    @PutMapping("/{id}")
    public Usuarios update(@RequestBody Usuarios usuarios, @PathVariable Long id){
        Usuarios usuarios2=usuariosService.findUsuarios(id);

            usuarios2.setEmail(usuarios.getEmail());
            usuarios2.setConfirmEmail(usuarios.getConfirmEmail());
            usuarios2.setPassword(usuarios.getPassword());
            usuarios2.setConfirmPassword(usuarios.getConfirmPassword());
            usuarios2.setNombreEdificio(usuarios.getNombreEdificio());
            usuarios2.setRut(usuarios.getRut());
            usuarios2.setEdificios(usuarios.getEdificios());

        return usuariosService.updateUsuarios(usuarios);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usuariosService.deleteUsuarios(id);
    }
}
