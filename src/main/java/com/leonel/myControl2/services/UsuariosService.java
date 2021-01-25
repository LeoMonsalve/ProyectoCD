package com.leonel.myControl2.services;

import java.util.List;
import java.util.Optional;

import com.leonel.myControl2.models.Usuarios;
import com.leonel.myControl2.repositories.UsuariosRepository;

import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository= usuariosRepository;
	}

  public List<Usuarios> allUsuarios(){
      return usuariosRepository.findAll();
  }

    public Usuarios createdUsuarios(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }
    public Usuarios findUsuarios(Long id){
        Optional<Usuarios>optionalUsuarios = usuariosRepository.findById(id);
        if( optionalUsuarios.isPresent()){
            return optionalUsuarios.get();
        }else{
            return null;
        }
    }
    public Usuarios updateUsuarios(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }

    public void deleteUsuarios(Long id){
        usuariosRepository.deleteById(id);
    }
}
