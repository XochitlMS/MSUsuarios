package com.test.stefanini.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.stefanini.Beans.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}
