package com.yfsmsystem.theintegrations.service.impl;

import com.yfsmsystem.theintegrations.components.ModelMapperComponent;
import com.yfsmsystem.theintegrations.entity.Endereco;
import com.yfsmsystem.theintegrations.entity.NumberVerify;
import com.yfsmsystem.theintegrations.entity.Usuario;
import com.yfsmsystem.theintegrations.entity.dto.UsuarioDto;
import com.yfsmsystem.theintegrations.execptions.UsuarioNotFoundException;
import com.yfsmsystem.theintegrations.repository.UsuarioRepository;
import com.yfsmsystem.theintegrations.service.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapperComponent modelMapper;
    private final ViaCepServiceImpl viaCepService;
    private final NumberVerifyServiceImpl numberVerifyService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapperComponent modelMapper, ViaCepServiceImpl viaCepService, NumberVerifyServiceImpl numberVerifyService) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.viaCepService = viaCepService;
        this.numberVerifyService = numberVerifyService;
    }


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
        NumberVerify numberVerify = modelMapper.maping().map(numberVerifyService.retornaDadosNumeroInformado(usuarioDto.getCelular()), NumberVerify.class);
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
