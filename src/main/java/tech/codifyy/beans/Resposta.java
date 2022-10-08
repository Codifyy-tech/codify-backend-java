package tech.codifyy.beans;

public class Resposta {
    private String mensagem;
    private String token;

    public Resposta() {
    }

    public Resposta(String mensagem, String token) {
        this.mensagem = mensagem;
        this.token = token;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
