package tech.codifyy.beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement
public class Usuario {

    private Integer id;
    private String email;
    private String genero;
    private String nome;
    private String senha;
    private Long telefone;
    private Date nascimento;
    private String tipo;
    private String endereco;
    private Integer cep;
    private String cidade;
    private String distrito;
    private String estado;

    public Usuario(){

    }

    public Usuario(Integer id, String email, String genero, String nome, String senha, Long telefone, Date nascimento, String tipo, String endereco, Integer cep, String cidade, String distrito, String estado) {
        this.id = id;
        this.email = email;
        this.genero = genero;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.tipo = tipo;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.distrito = distrito;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}