package com.yfsmsystem.theintegrations.service.impl;

import com.yfsmsystem.theintegrations.consumer.NumberVerifyIntegracao;
import com.yfsmsystem.theintegrations.entity.NumberVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NumberVerifyServiceImpl {

    @Autowired
    NumberVerifyIntegracao numberVerifyIntegracao;

    @Value("${token.acess.api}")
    private String tokenAcessApi;

    public NumberVerify retornaDadosNumeroInformado(String numeroCelular) {
        //Validar se numero correto
        return numberVerifyIntegracao.getValidacaoNumero(tokenAcessApi, this.validaNumeroCelular(numeroCelular));
    }

    private String validaNumeroCelular(String celular) {
        return celular.contains("+55") ? celular : "+55" + celular;
    }
}
