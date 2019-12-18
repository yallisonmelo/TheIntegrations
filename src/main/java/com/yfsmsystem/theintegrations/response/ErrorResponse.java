package com.yfsmsystem.theintegrations.response;

import java.util.StringJoiner;

public class ErrorResponse<T> {

    private int codError;
    private String message;
    private String details;
    private T erros;


    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public T getErros() {
        return erros;
    }

    public void setErros(T erros) {
        this.erros = erros;
    }


    public ErrorResponse(int codError, String message, String details, T erros) {
        this.codError = codError;
        this.message = message;
        this.details = details;
        this.erros = erros;
    }

    public ErrorResponse() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ErrorResponse.class.getSimpleName() + "[", "]")
                .add("codError=" + codError)
                .add("message='" + message + "'")
                .add("details='" + details + "'")
                .add("erros=" + erros)
                .toString();
    }
}
