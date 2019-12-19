package com.yfsmsystem.theintegrations.consumer;

import com.yfsmsystem.theintegrations.dto.NumberVerifyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://apilayer.net/api", name = "numberverify")
public interface NumberVerifyIntegracao {


    @GetMapping("/validate?access_key={token}&number={numero}")
    NumberVerifyDto getValidacaoNumero(@PathVariable(value = "token") String token, @PathVariable(value = "numero") String numero);
}
