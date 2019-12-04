package com.yfsmsystem.theapp.execptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() {
        super("Could not find User");
    }
}
