package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector.MysqlConnector;
import model.FoodModel;

public class FoodDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public List<FoodModel> findListFoot() {
		List<FoodModel> listFoot = new ArrayList<FoodModel>();
		connect = instance.getDataBaseConnectionPool();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = connect.prepareStatement("SELECT * FROM food");
			rs = pstm.executeQuery();
			while (rs.next()) {
				int idFoot = rs.getInt("idFood");
				String nameFoot = rs.getString("nameFood");
				String note = rs.getString("note");
				FoodModel nc = new FoodModel(idFoot, nameFoot, note);
				listFoot.add(nc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return listFoot;
	}

	public void deleteFood(int idFood) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("DELETE FROM food WHERE idFood=?");
			pstm.setInt(1, idFood);
			pstm.executeUpdate();
			instance.closeConnection(connect);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void addFood(FoodModel foodModel) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("insert into food(nameFood,note) values (?, ? )");
			pstm.setString(1, foodModel.getNameFoot());
			pstm.setString(2, foodModel.getNote());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}
	public void updateFood(FoodModel foodModel) {

		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
//			pstm = connect.prepareStatement(""
//					+ "UPDATE food SET nameFood=N'"+foodModel.getNameFoot()+"', "
//							+ "note=N'"+foodModel.getNote()+"' "
//									+ "where idFood= "+foodModel.getIdFood());
			pstm = connect.prepareStatement("UPDATE food SET nameFood=?, note=? where idFood=?");
			pstm.setInt(3, foodModel.getIdFood());
			pstm.setString(1, foodModel.getNameFoot());
			pstm.setString(2, foodModel.getNote());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}
	public FoodModel getFoodById(int idFood) {
		connect = instance.getDataBaseConnectionPool();
		FoodModel foodModel = new FoodModel();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connect.prepareStatement("select * from food where idFood=?");
			preparedStatement.setInt(1, idFood);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				foodModel.setIdFood(rs.getInt("idFood"));
				foodModel.setNameFoot(rs.getString("nameFood"));
				foodModel.setNote(rs.getString("note"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(preparedStatement);
			instance.closeConnection(connect);
		}

		return foodModel;
	}

}
