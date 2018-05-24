package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.MysqlConnector;
import model.ManageModel;

public class ManageDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public List<ManageModel> findListManage() {
		List<ManageModel> listManage = new ArrayList<ManageModel>();
		connect = instance.getDataBaseConnectionPool();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = connect.prepareStatement("SELECT * FROM manage");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int idManage = rs.getInt("idManage");
				String nameManage = rs.getString("nameManage");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				ManageModel nc = new ManageModel(idManage, nameManage, address, phone);
				listManage.add(nc);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return listManage;
	}

	public void addManage(ManageModel manageModel) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("insert into manage(nameManage,address,phone) values (?, ?, ? )");
			pstm.setString(1, manageModel.getNameManage());
			pstm.setString(2, manageModel.getAddress());
			pstm.setString(3, manageModel.getPhone());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void deleteManage(int idManage) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("DELETE FROM manage WHERE idManage=?");
			pstm.setInt(1, idManage);
			pstm.executeUpdate();
			instance.closeConnection(connect);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void updateManage(ManageModel manageModel) {

		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("UPDATE manage SET nameManage=?, address=?, phone=? where idManage=?");
			pstm.setInt(4, manageModel.getIdManage());
			pstm.setString(1, manageModel.getNameManage());
			pstm.setString(2, manageModel.getAddress());
			pstm.setString(3, manageModel.getPhone());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public ManageModel getManageById(int idManage) {
		connect = instance.getDataBaseConnectionPool();
		ManageModel manageModel = new ManageModel();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("select * from manage where idManage=?");
			preparedStatement.setInt(1, idManage);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				manageModel.setIdManage(rs.getInt("idManage"));
				manageModel.setNameManage(rs.getString("nameManage"));
				manageModel.setAddress(rs.getString("address"));
				manageModel.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(preparedStatement);
			instance.closeConnection(connect);
		}

		return manageModel;
	}
}