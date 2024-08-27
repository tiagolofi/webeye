package com.github.tiagolofi.webeye.mensageria;

public class Mensagem {
    
    public String mensagem;
    public Object objetoSerial;

    public Mensagem(String mensagem, Object objetoSerial) {
        this.mensagem = mensagem;
        this.objetoSerial = objetoSerial;
    }

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
