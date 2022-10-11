package tech.codifyy.dao;

import tech.codifyy.beans.Trilha;
import tech.codifyy.bo.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class TrilhaDAO {

    private final Connection connection;

    public TrilhaDAO(Connection connection) {
        this.connection = connection;
    }

    public String converter(List<String> lista) {
        StringBuilder builder = new StringBuilder();
        for (String item : lista) {
            builder.append(item);
        }
        String items = builder.toString();
        return items;
    }

    public String inserir(Trilha trilha) throws Excecao {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO T_SCPD_TRILHA "
                    + "(ID_TRILHA, ID_TECNOLOGIA, NM_TRILHA, DS_URL_TRILHA, NM_AUTOR, DS_TRILHA, DS_TOPICOS, NM_CATEGORIA)"
                    + "VALUES "
                    +"(?, ?, ?, ?, ?, ?, ?, ? )"

            );
            preparedStatement.setInt(1, trilha.get_id());
            preparedStatement.setInt(2, trilha.getTechnology().get_id());
            preparedStatement.setString(3, trilha.getTitle());
            preparedStatement.setString(4, trilha.getUrl());
            preparedStatement.setString(5, trilha.getAuthor());
            preparedStatement.setString(6, trilha.getDescription());
            preparedStatement.setString(7, converter(trilha.getTopics()));
            preparedStatement.setString(8, trilha.getCategory());

            if (preparedStatement.executeUpdate() > 0) {
                return "Cadastrado com sucesso";
            } else {
                return "Erro ao cadastrar";
            }
        } catch (SQLException e) {
            throw new Excecao(e.getMessage());
        }
    }
}
