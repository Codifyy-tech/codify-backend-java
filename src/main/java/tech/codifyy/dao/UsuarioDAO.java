package tech.codifyy.dao;

import tech.codifyy.beans.Usuario;
import tech.codifyy.exception.Excecao;
import tech.codifyy.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			user.setString(2, usuario.getGenre());
			user.setString(3, usuario.getName());
			user.setString(4, usuario.getPassword());
			user.setLong(5, usuario.getPhone());
			user.setDate(6, new java.sql.Date(usuario.getBirth_date().getTime()));
			user.setString(7, usuario.getType());
			user.setString(8, usuario.getAddress());
			user.setInt(9, usuario.getCep());
			user.setString(10, usuario.getCity());
			user.setString(11, usuario.getDistrict());
			user.setString(12, usuario.getState());

			if (user.executeUpdate() > 0) {
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

	// Update Senha
	public String alterarSenha(Usuario usuario) {
		PreparedStatement user = null;
		try {
			user = connection.prepareStatement("update T_SCPD_USUARIO set ds_senha = ? where id_usuario = ?");
			user.setString(1, usuario.getPassword());
			user.setInt(2, usuario.get_id());
			if (user.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			Conexao.fecharConexao(connection);
		}
	}

	// Selecionar todos

	private static ArrayList<Usuario> retornarUsuario;
	public ArrayList<Usuario> select() {
		PreparedStatement user = null;
		ArrayList<Usuario> retornarUsuario = new ArrayList<>();
		try {
			user = connection.prepareStatement("select * from T_SCPD_USUARIO");
			ResultSet rs = user.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.set_id(rs.getInt(1));
					usuario.setEmail(rs.getString(2));
					usuario.setGenre(rs.getString(3));
					usuario.setName(rs.getString(4));
					usuario.setPassword(rs.getString(5));
					usuario.setPhone(rs.getLong(6));
					usuario.setBirth_date(rs.getDate(7));
					usuario.setType(rs.getString(8));
					usuario.setAddress(rs.getString(9));
					usuario.setCep(rs.getInt(10));
					usuario.setCity(rs.getString(11));
					usuario.setDistrict(rs.getString(12));
					usuario.setState(rs.getString(13));
					retornarUsuario.add(usuario);
				}
				return retornarUsuario;
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new Excecao(e.getMessage());
		} finally {
			Conexao.fecharConexao(connection);
		}
	}


	// Selecionar por ID
	public Usuario selectId(int id){
		PreparedStatement user = null;
		try {
			user = connection.prepareStatement("select * from T_SCPD_USUARIO");
			ResultSet rs = user.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					if(rs.getInt(1) == id){
						Usuario usuario = new Usuario();
						usuario.set_id(rs.getInt(1));
						usuario.setEmail(rs.getString(2));
						usuario.setGenre(rs.getString(3));
						usuario.setName(rs.getString(4));
						usuario.setPassword(rs.getString(5));
						usuario.setPhone(rs.getLong(6));
						usuario.setBirth_date(rs.getDate(7));
						usuario.setType(rs.getString(8));
						usuario.setAddress(rs.getString(9));
						usuario.setCep(rs.getInt(10));
						usuario.setCity(rs.getString(11));
						usuario.setDistrict(rs.getString(12));
						usuario.setState(rs.getString(13));
						return usuario;
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

	public Usuario selecionarEmail(String email){
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(
					"SELECT * FROM T_SCPD_USUARIO "
							+ "WHERE DS_EMAIL = ?"
			);
			preparedStatement.setString(1, email);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				if (rs.getString(2).equals(email)) {
					Usuario usuario = new Usuario();
					usuario.set_id(rs.getInt(1));
					usuario.setEmail(rs.getString(2));
					usuario.setGenre(rs.getString(3));
					usuario.setName(rs.getString(4));
					usuario.setPassword(rs.getString(5));
					usuario.setPhone(rs.getLong(6));
					usuario.setBirth_date(rs.getDate(7));
					usuario.setType(rs.getString(8));
					usuario.setAddress(rs.getString(9));
					usuario.setCep(rs.getInt(10));
					usuario.setCity(rs.getString(11));
					usuario.setDistrict(rs.getString(12));
					usuario.setState(rs.getString(13));
					return usuario;
				} else {
					return null;
				}
			}

			return null;
		} catch (SQLException e) {
			throw new Excecao(e.getMessage());
		} finally {
			Conexao.fecharConexao(connection);
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
		} finally {
			Conexao.fecharConexao(connection);
		}
	}
}
