package tech.codifyy.dao;

import tech.codifyy.beans.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

	private final Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	// Inserir usuario
	public String inserir(Usuario usuario) {
		PreparedStatement user = null;
		try {
			user = connection.prepareStatement("INSERT INTO T_SCPD_USUARIO "
					+ "(ds_email, ds_genero, nm_completo, ds_senha, nr_telefone, dt_nascimento, ds_tipo, ds_endereco, ds_cep, ds_cidade, ds_distrito, ds_estado) "
					+ "VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?)");
			user.setString(1, usuario.getEmail());
			user.setString(2, usuario.getGenero());
			user.setString(3, usuario.getNome());
			user.setString(4, usuario.getSenha());
			user.setLong(5, usuario.getTelefone());
			user.setDate(6, new java.sql.Date(usuario.getNascimento().getTime()));
			user.setString(7, usuario.getTipo());
			user.setString(8, usuario.getEndereco());
			user.setInt(9, usuario.getCep());
			user.setString(10, usuario.getCidade());
			user.setString(11, usuario.getDistrito());
			user.setString(12, usuario.getEstado());

			if (user.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Update Senha
	public String alterarSenha(Usuario usuario) {
		PreparedStatement user = null;
		try {
			user = connection.prepareStatement("update T_SCPD_USUARIO set ds_senha = ? where id_usuario = ?");
			user.setString(1, usuario.getSenha());
			user.setInt(2, usuario.getId());
			if (user.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}



	// Deletar apenas para testar
	public String deletar(Usuario usuario) {
		PreparedStatement user = null;
		try {
			user = connection.prepareStatement("DELETE FROM T_SCPD_USUARIO ");
			if (user.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
