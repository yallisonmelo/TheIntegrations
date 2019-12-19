package com.yfsmsystem.theintegrations.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioDto {

    @NotEmpty(message = "O Campo Nome é Necessário")
    @NotBlank(message = "O Campo Nome não pode ficar em branco")
    @NotNull(message = "O Campo Nome não Pode Ser Null")
    private String nome;
    @CPF(message = "CPF Invalido")
    @NotEmpty(message = "O Campo CPF Necessário")
    @Length(min = 11, max = 11, message = "CPF precisa ter 11 digitos.")
    private String cpf;
    @Email(message = "Email Invalido")
    @NotEmpty(message = "O Campo Email é Necessário")
    private String email;
    @NotEmpty(message = "O Campo Senha é Necessário")
    private String senha;
    private Integer idade;
    @NotEmpty(message = "Campo Celular é Necessário")
    @Length(min = 8, max = 8, message = "O Campo CEP  precisa ter 8 digitos.")
    private String cep;
    @NotEmpty(message = "Campo Celular Necessário")
    @Length(min = 11, max = 11, message = "celular precisa ter 11 digitos.")
    private String celular;
}
