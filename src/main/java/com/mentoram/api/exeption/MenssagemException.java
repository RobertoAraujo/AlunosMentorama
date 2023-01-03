package com.mentoram.api.exeption;

public class MenssagemException extends Exception{
    public MenssagemException(final String message) {
        super("Aluno inexistente!" + message + "aquiiii!!!");
    }
}
