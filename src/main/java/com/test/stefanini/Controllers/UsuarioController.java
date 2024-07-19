package com.test.stefanini.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.stefanini.Beans.Usuario;
import com.test.stefanini.Services.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	private static final Logger logger = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
    	logger.info("GET /api/usuarios");
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
    	logger.info("GET /api/usuarios/{}", id);
        return usuarioService.getUsuarioById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.status(400).body(null));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
    	 logger.info("POST /api/usuarios");
        return ResponseEntity.ok(usuarioService.createUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
    	logger.info("PUT /api/usuarios", id);
        try {
            return ResponseEntity.ok(usuarioService.updateUsuario(id, usuarioDetalles));
        } catch (RuntimeException e) {
        	logger.error("Error al acutalizar al usuario con id: {}", id, e);
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
    	 logger.info("DELETE /api/usuarios/{}", id);
    	usuarioService.deleteUsuario(id);
        return ResponseEntity.ok().build();
    }
    
    
    @PatchMapping("actualizaNombre/{id}")
    public ResponseEntity<Usuario> patchUsuarioNombre(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
    	logger.info("PATCH /api/usuarios", id);
    	try {
            return ResponseEntity.ok(usuarioService.patchUsuarioNombre(id, usuarioDetalles));
        } catch (RuntimeException e) {
        	logger.error("Error al acutalizar al usuario con id: {}", id, e);
            return ResponseEntity.status(400).body(null);
        }
    }

}
