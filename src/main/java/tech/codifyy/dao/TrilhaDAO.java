package tech.codifyy.dao;

import tech.codifyy.beans.Trilha;
import tech.codifyy.beans.Usuario;
import tech.codifyy.exception.Excecao;
import tech.codifyy.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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

    // INSERIR TRILHA
    public String inserir(Trilha trilha) throws Excecao {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO T_SCPD_TRILHA "
                    + "(ID_TECNOLOGIA, NM_TRILHA, DS_URL_TRILHA, NM_AUTOR, DS_TRILHA, DS_TOPICOS, NM_CATEGORIA)"
                    + "VALUES "
                    +"(?, ?, ?, ?, ?, ?, ? )"

            );
            preparedStatement.setInt(1, trilha.getId_tecnologia());
            preparedStatement.setString(2, trilha.getTitle());
            preparedStatement.setString(3, trilha.getUrl());
            preparedStatement.setString(4, trilha.getAuthor());
            preparedStatement.setString(5, trilha.getDescription());
            preparedStatement.setString(6, converter(trilha.getTopics()));
            preparedStatement.setString(7, trilha.getCategory());

            if (preparedStatement.executeUpdate() > 0) {
                return "Cadastrado com sucesso";
            } else {
                return "Erro ao cadastrar";
            }
        } catch (SQLException e) {
            return e.getMessage();
        } finally {
            Conexao.fecharConexao(connection);
        }

    }

    // LISTAR TRILHAS
    public List<Trilha> selecionarTrilhas(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Trilha> trilhas = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM T_SCPD_TRILHA "
            );
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Trilha trilha = new Trilha();
                    trilha.set_id(resultSet.getInt(1));
                    trilha.setId_tecnologia(resultSet.getInt(2));
                    trilha.setTitle(resultSet.getString(3));
                    trilha.setUrl(resultSet.getString(4));
                    trilha.setAuthor(resultSet.getString(5));
                    trilha.setDescription(resultSet.getString(6));
                    trilha.setTopics(new ArrayList<>(Arrays.asList(resultSet.getString(7).split(","))));
                    trilha.setCategory(resultSet.getString(8));

                    trilhas.add(trilha);
                }
                return trilhas;
            } else {
                return null;
            }
        } catch(SQLException e){
            throw new Excecao(e.getMessage());
        } finally {
            Conexao.fecharConexao(connection);
        }
    }

    // LISTAR TRILHAS POR ID
    public Trilha selectId(int id){
        PreparedStatement user = null;
        try {
            user = connection.prepareStatement("select * from T_SCPD_TRILHA");
            ResultSet rs = user.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    if(rs.getInt(1) == id){
                        Trilha trilha = new Trilha();
                        trilha.set_id(rs.getInt(1));
                        trilha.setId_tecnologia(rs.getInt(2));
                        trilha.setTitle(rs.getString(3));
                        trilha.setUrl(rs.getString(4));
                        trilha.setAuthor(rs.getString(5));
                        trilha.setDescription(rs.getString(6));
                        trilha.setTopics((List<String>) rs.getArray(7));
                        trilha.setCategory(rs.getString(8));
                        return trilha;
                    } else{
                        System.out.println("Usuario não encontrado");
                    }
                }
                return null;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new Excecao(e.getMessage());
        } finally {
            Conexao.fecharConexao(connection);
        }
    }
}
