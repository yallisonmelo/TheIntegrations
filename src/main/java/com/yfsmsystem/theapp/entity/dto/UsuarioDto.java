package com.yfsmsystem.theapp.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    private Long codigo;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Integer idade;
    private String cep;
    private String celular;
}
