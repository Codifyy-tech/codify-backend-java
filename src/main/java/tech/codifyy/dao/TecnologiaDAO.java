package tech.codifyy.dao;

import tech.codifyy.beans.Tecnologia;
import tech.codifyy.exception.Excecao;
import tech.codifyy.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TecnologiaDAO {

    private final Connection connection;

    public TecnologiaDAO(Connection connection) {
        this.connection = connection;
    }

    public String inserir(Tecnologia tecnologia) {
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO T_SCPD_TECNOLOGIA"
                            + "(NM_TECNOLOGIA,CD_COR_FUNDO, DS_ICONE)"
            );
            preparedStatement.setString(1, tecnologia.getName());
            preparedStatement.setString(2, tecnologia.getColor());
            preparedStatement.setString(3, tecnologia.getIcon());

            if (preparedStatement.executeUpdate() > 0) {
                return "Cadastrado com sucesso";
            } else {
                return "Erro ao cadastrar";
            }
        } catch (SQLException e) {
            throw new Excecao(e.getMessage());
        } finally {
            Conexao.fecharConexao(connection);
        }
    }
}
