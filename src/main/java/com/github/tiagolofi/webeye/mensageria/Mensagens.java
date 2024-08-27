package com.github.tiagolofi.webeye.mensageria;

public enum Mensagens {
    
    ADICIONADO(new Mensagem("Adicionado com sucesso!")),
    NAO_AUTORIZADO(new Mensagem("Acesso não autorizado")),
    DELETADO(new Mensagem("As informações foram apagadas")),
    ATUALIZADO(new Mensagem("As informações foram atualizadas"));

    private Mensagem mensagem;

    private Mensagens (Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

}
