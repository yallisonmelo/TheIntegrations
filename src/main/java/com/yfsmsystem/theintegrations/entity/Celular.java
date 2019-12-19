package com.yfsmsystem.theintegrations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contato")
@NoArgsConstructor
public class Celular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean valido;
    private String operadora;
    private String tipoLinha;
    private String numero;
    private Long usuario_id;
}
