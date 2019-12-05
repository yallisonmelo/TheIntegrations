package com.yfsmsystem.theintegrations.service.impl;

import com.yfsmsystem.theintegrations.components.ModelMapperComponent;
import com.yfsmsystem.theintegrations.consumer.ViaCepIntegracao;
import com.yfsmsystem.theintegrations.dto.ViaCepDto;
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
