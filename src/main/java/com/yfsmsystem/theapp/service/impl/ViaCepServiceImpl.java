package com.yfsmsystem.theapp.service.impl;

import com.yfsmsystem.theapp.components.ModelMapperComponent;
import com.yfsmsystem.theapp.consumer.ViaCepIntegracao;
import com.yfsmsystem.theapp.dto.ViaCepDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaCepServiceImpl {

    @Autowired
    ViaCepIntegracao viaCepIntegracao;
    @Autowired
    ModelMapperComponent modelMapperComponent;


    public ViaCepDto retornaDadosEndereco(String cep) {
        return modelMapperComponent.mappingAndReturnFieldNotEmpity().map(viaCepIntegracao.getViacCep(cep), ViaCepDto.class);
    }
}
