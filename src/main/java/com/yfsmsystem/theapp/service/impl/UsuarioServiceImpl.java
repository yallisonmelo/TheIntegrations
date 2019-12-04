package com.yfsmsystem.theapp.service.impl;

import com.yfsmsystem.theapp.components.ModelMapperComponent;
import com.yfsmsystem.theapp.entity.Endereco;
import com.yfsmsystem.theapp.entity.Usuario;
import com.yfsmsystem.theapp.entity.dto.UsuarioDto;
import com.yfsmsystem.theapp.execptions.UsuarioNotFoundException;
import com.yfsmsystem.theapp.repository.UsuarioRepository;
import com.yfsmsystem.theapp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ModelMapperComponent modelMapper;
    @Autowired
    ViaCepServiceImpl viaCepService;


    public List<Usuario> listaTodosUsuario() {
        return Optional.ofNullable(usuarioRepository.findAll()).orElseThrow(UsuarioNotFoundException::new);
    }

    public Optional<Usuario> retornaUsuarioPorId(Long id) {
        return Optional.ofNullable(usuarioRepository.findById(id)).orElseThrow(UsuarioNotFoundException::new);
    }


    public Usuario inserirNovoUsuario(UsuarioDto usuarioDto) {
        List<Endereco> listEndereco = new ArrayList<>();
        Usuario usuario = modelMapper.maping().map(usuarioDto, Usuario.class);
        Endereco endereco = modelMapper.maping().map(viaCepService.retornaDadosEndereco(usuarioDto.getCep()), Endereco.class);
        listEndereco.add(endereco);
        usuario.setEndereco(listEndereco);
        return usuarioRepository.save(usuario);
    }


    public UsuarioDto atualizarUsuario(UsuarioDto usuarioDto, Long id) {
        this.retornaUsuarioPorId(id).ifPresent(x -> usuarioRepository.save(modelMapper.maping().map(usuarioDto, Usuario.class)));
        return usuarioDto;
    }


    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
