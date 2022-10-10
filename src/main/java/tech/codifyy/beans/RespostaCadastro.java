package tech.codifyy.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RespostaCadastro {
    private String mensagem;
    private Integer id;

    public RespostaCadastro() {
    }

    public RespostaCadastro(String mensagem, Integer id) {
        this.mensagem = mensagem;
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
