package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import connector.MysqlConnector;
import model.UserModel;

public class LoginDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public Map<Integer, Integer> login(UserModel user) {
		Map<Integer, Integer> map = new HashMap<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement(
					"SELECT nameUser, password, role, idUser FROM user WHERE nameUser =? AND password =?");
			pstm.setString(1, user.getNameUser());
			pstm.setString(2, user.getPassword());
			rs = pstm.executeQuery();
			while (rs.next()) {
				String username = rs.getString("nameUser");
				String password = rs.getString("password");
				if (username.equals(user.getNameUser()) && password.equals(user.getPassword())) {
					map.put(rs.getInt("idUser"), rs.getInt("role"));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return map;
	}
}
