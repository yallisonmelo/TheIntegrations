package com.yfsmsystem.theapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Integer idade;
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Endereco> endereco;
}
