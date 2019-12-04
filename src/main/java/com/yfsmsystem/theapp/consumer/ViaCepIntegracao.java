package com.yfsmsystem.theapp.consumer;


import com.yfsmsystem.theapp.dto.ViaCepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep.com.br")
public interface ViaCepIntegracao {

    @GetMapping("/{cep}/json/")
     ViaCepDto getViacCep(@PathVariable(value = "cep") String cep);
}
