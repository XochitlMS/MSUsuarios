package com.test.stefanini.Services;

import java.util.List;
import java.util.Optional;

import com.test.stefanini.Beans.Usuario;

public interface UsuarioService {
	    List<Usuario> getAllUsuarios();
	    Optional<Usuario> getUsuarioById(Long id);
	    Usuario createUsuario(Usuario user);
	    Usuario updateUsuario(Long id, Usuario usuarioDetalles);
	    Usuario patchUsuarioNombre(Long id, Usuario usuarioDetalles);
	    void deleteUsuario(Long id);

}
