package com.yfsmsystem.theintegrations.execptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() {
        super("Usuario Não Localizado");
    }
}
