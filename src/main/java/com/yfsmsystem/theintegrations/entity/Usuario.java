package com.yfsmsystem.theintegrations.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    private String celular;
    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<Endereco>();
}
