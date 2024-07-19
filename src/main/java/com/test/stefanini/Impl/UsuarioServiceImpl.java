package com.test.stefanini.Impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.stefanini.Beans.Usuario;
import com.test.stefanini.DAO.UsuarioDao;
import com.test.stefanini.Services.UsuarioService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	 
	private static final Logger logger = LogManager.getLogger(UsuarioServiceImpl.class);

	
	@Autowired
    private UsuarioDao usuarioDao;

    public List<Usuario> getAllUsuarios() {
    	logger.info("`Recuperando a todos los usuarios");
        return usuarioDao.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
    	logger.info("Recuperando al usuario con id: " + id);
        return usuarioDao.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
    	logger.info("Creando nuevo usuario: " + usuario.getNombre());
        return usuarioDao.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetalles) {
    	logger.info("Actualizando el usuario con id: " + id);
    	Usuario usuario = usuarioDao.findById(id).orElseThrow(() ->
    	{logger.error("El usuario con id: " + id +"No fue encontrado");
        return new RuntimeException("Usuario no encontrado"); });
    	usuario.setNombre(usuarioDetalles.getNombre());
    	usuario.setApellidoM(usuarioDetalles.getApellidoM());
    	usuario.setApellidoP(usuarioDetalles.getApellidoP());
        usuario.setEmail(usuarioDetalles.getEmail());
        return usuarioDao.save(usuario);
    }
    
    public Usuario patchUsuarioNombre(Long id, Usuario usuarioDetalles) {
    	logger.info("Actualizando el nombre del usuario con id: " + id);
    	Usuario usuario = usuarioDao.findById(id).orElseThrow(() ->
    	{logger.error("El usuario con id: " + id +"No fue encontrado");
        return new RuntimeException("Usuario no encontrado"); });
    	if (usuarioDetalles.getNombre() != null) {
            usuario.setNombre(usuarioDetalles.getNombre());
        }
    	if (usuarioDetalles.getApellidoM() != null) {
            usuario.setApellidoM(usuarioDetalles.getApellidoM());
        }
    	if (usuarioDetalles.getApellidoP() != null ) {
            usuario.setApellidoP(usuarioDetalles.getApellidoP());
        }
    	if (usuarioDetalles.getEmail() != null ) {
            usuario.setEmail(usuarioDetalles.getEmail());
        }
    	return usuarioDao.save(usuario);
    }
    
    public void deleteUsuario(Long id) {
    	logger.info("Borrando usuario con id: " + id);
    	usuarioDao.deleteById(id);
    }
    
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioDao.save(usuario);
    }
    
   

}
