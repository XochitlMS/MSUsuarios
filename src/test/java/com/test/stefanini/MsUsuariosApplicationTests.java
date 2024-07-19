package com.test.stefanini;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.test.stefanini.Beans.Usuario;
//import com.test.stefanini.Controllers.UsuarioController;
import com.test.stefanini.Impl.UsuarioServiceImpl;
import java.util.Optional;

//import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MsUsuariosApplicationTests {

	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioServiceImpl usuarioServiceImpl;
   
    
    public MsUsuariosApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testGetUsuarioById() throws Exception {
    	Usuario usuario = new Usuario();
    	usuario.setId(1L);
    	usuario.setNombre("Ana");
    	usuario.setApellidoP("Lopez");
    	usuario.setApellidoM("Perez");
    	usuario.setEmail("ana.lopez@example.com");

        when(usuarioServiceImpl.getUsuarioById(1L)).thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ana"))
                .andExpect(jsonPath("$.apellidoP").value("Lopez"))
                .andExpect(jsonPath("$.apellidoM").value("Perez"))
                .andExpect(jsonPath("$.email").value("ana.lopez@example.com"));
    }
    
    
    @Test
    public void testCreateUsuario() throws Exception {
    	Usuario usuario = new Usuario();
    	usuario.setNombre("Diana");
    	usuario.setApellidoP("Fernandez");
    	usuario.setApellidoM("Lozano");
    	usuario.setEmail("diana.hernandez@example.com");

        when(usuarioServiceImpl.createUsuario(any(Usuario.class))).thenReturn(usuario);
        
       
        mockMvc.perform(post("/api/usuarios")
                .contentType("application/json")
                .content("{\"nombre\": \"Ana\", \"email\": \"diana.hernandez@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Diana"))
                .andExpect(jsonPath("$.apellidoP").value("Fernandez"))
                .andExpect(jsonPath("$.apellidoM").value("Lozano"))
                .andExpect(jsonPath("$.email").value("diana.hernandez@example.com"));
    }
    
}
