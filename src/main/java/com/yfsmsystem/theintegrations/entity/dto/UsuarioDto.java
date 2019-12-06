package com.yfsmsystem.theintegrations.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UsuarioDto {
    private Long codigo;
    private String nome;
    private String cpf;
    @Email
    private String email;
    private String senha;
    private Integer idade;
    private String cep;
    @NotEmpty(message = "Campo Celular Necessário")
    private String celular;
}
