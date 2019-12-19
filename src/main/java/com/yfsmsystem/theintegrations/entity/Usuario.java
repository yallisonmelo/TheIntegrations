package com.yfsmsystem.theintegrations.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Integer idade;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id")
    private List<Endereco> endereco;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="usuario_id")
    private List<Celular>contato;
}
