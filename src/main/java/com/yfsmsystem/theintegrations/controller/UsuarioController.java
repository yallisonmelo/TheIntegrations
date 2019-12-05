package com.yfsmsystem.theintegrations.controller;

import com.yfsmsystem.theintegrations.entity.dto.UsuarioDto;
import com.yfsmsystem.theintegrations.execptions.UsuarioNotFoundException;
import com.yfsmsystem.theintegrations.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity exibeTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.listaTodosUsuario());
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.retornaUsuarioPorId(id));

    }

    @PostMapping
    public ResponseEntity inserirNovoUsuario(@RequestBody @Valid UsuarioDto usuarioDto, BindingResult result) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioService.inserirNovoUsuario(usuarioDto).getCodigo()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity atualizarUsuario(@RequestBody @Valid UsuarioDto userDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.atualizarUsuario(userDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok().body("Usuario deletado");
        } catch (UsuarioNotFoundException e) {
            return ResponseEntity.badRequest().body("Falha na Operacao");
        }
    }
}
