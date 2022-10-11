package tech.codifyy.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespostaCadastro {
    private String mensagem;

    public RespostaCadastro() {
    }

    public RespostaCadastro(String mensagem) {
        this.mensagem = mensagem;

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
