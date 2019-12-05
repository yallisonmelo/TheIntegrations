package com.yfsmsystem.theintegrations.repository;

import com.yfsmsystem.theintegrations.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


}
