package tech.codifyy.beans;

public class Resposta {
    private String mensagem;
    private Integer id;

    public Resposta() {
    }

    public Resposta(String mensagem, Integer id) {
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
