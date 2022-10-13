package tech.codifyy.test;

import tech.codifyy.beans.Trilha;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.TrilhaDAO;

import java.sql.Connection;
import java.util.Collections;

public class TrilhaInserir {
    public static void main(String[] args){

        Connection con = Conexao.abrirConexao();

        Trilha trilha = new Trilha();

        TrilhaDAO trilhadao = new TrilhaDAO(con);

        // Inserir trilha

        trilha.setId_tecnologia(1);
        trilha.setTitle("Trilha teste");
        trilha.setUrl("teste.com.br");
        trilha.setAuthor("Rafael");
        trilha.setDescription("Apenas um teste");
        trilha.setTopics(Collections.singletonList("lista teste"));
        trilha.setCategory("FrontEnd");

        System.out.println(trilhadao.inserir(trilha));

        Conexao.fecharConexao(con);

    }
}