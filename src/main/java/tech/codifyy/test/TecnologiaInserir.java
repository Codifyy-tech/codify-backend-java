package tech.codifyy.test;

import tech.codifyy.beans.Tecnologia;
import tech.codifyy.conexao.Conexao;
import tech.codifyy.dao.TecnologiaDAO;
import tech.codifyy.exception.Excecao;

import java.sql.Connection;
import java.text.ParseException;

public class TecnologiaInserir {
    public static void main(String[] args){

        Connection con = Conexao.abrirConexao();

        Tecnologia tech = new Tecnologia();

        TecnologiaDAO techdao = new TecnologiaDAO(con);

        // Inserir trilha

        tech.setName("Python");
        tech.setColor("#fff");
        tech.setIcon("imagem");

        System.out.println(techdao.inserir(tech));

        Conexao.fecharConexao(con);

    }
}
