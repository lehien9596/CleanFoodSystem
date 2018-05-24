package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connector.MysqlConnector;
import model.UserModel;

public class UserDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public List<UserModel> findUser() {
		List<UserModel> listUser = new ArrayList<UserModel>();
		connect = instance.getDataBaseConnectionPool();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = connect.prepareStatement("SELECT * FROM user");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int idUser = rs.getInt("idUser");
				String nameUser = rs.getString("nameUser");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int role = rs.getInt("role");
				UserModel nc = new UserModel(idUser, nameUser, password, email, role);
				listUser.add(nc);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return listUser;
	}

	public void addUser(UserModel userModel) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("insert into user(nameUser,password,email,role) values (?, ?, ?, ? )");
			pstm.setString(1, userModel.getNameUser());
			pstm.setString(2, userModel.getPassword());
			pstm.setString(3, userModel.getEmail());
			pstm.setInt(4, userModel.getRole());

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void deleteUser(int idUser) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("DELETE FROM user WHERE idUser=?");
			pstm.setInt(1, idUser);
			pstm.executeUpdate();
			instance.closeConnection(connect);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}

		deleteProductByIdProvider(idUser);
	}

	private void deleteProductByIdProvider(int idUser) {
	}

	public void updateUser(UserModel userModel) {

		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("UPDATE user SET nameUser=?, password=?, email=?, role=? where idUser=?");
			pstm.setString(1, userModel.getNameUser());
			pstm.setString(2, userModel.getPassword());
			pstm.setString(3, userModel.getEmail());
			pstm.setInt(4, userModel.getRole());
			pstm.setInt(5, userModel.getIdUser());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public UserModel getUserById(int idUser) {
		UserModel userModel = new UserModel();
		PreparedStatement preparedStatement = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			preparedStatement = connect.prepareStatement("select * from user where idUser=?");
			preparedStatement.setInt(1, idUser);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				userModel.setIdUser(rs.getInt("idUser"));
				userModel.setNameUser(rs.getString("nameUser"));
				userModel.setPassword(rs.getString("password"));
				userModel.setEmail(rs.getString("email"));
				userModel.setRole(rs.getInt("role"));
			}
			instance.closeConnection(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(preparedStatement);
			instance.closeConnection(connect);
		}

		return userModel;
	}

	public List<UserModel> searchUser(String textSearch) {
		List<UserModel> listUsers = new ArrayList<>();
		SearchDAO search = new SearchDAO();
		ResultSet rs = search.search(textSearch, Arrays.asList("nameUser", "email"), "user");
		try {
			while (rs.next()) {
				int idUser = rs.getInt("idUser");
				String nameUser = rs.getString("nameUser");
				String email = rs.getString("email");
				int role = rs.getInt("role");
				UserModel user = new UserModel(idUser, nameUser, "", email, role);
				listUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUsers;
	}
}
