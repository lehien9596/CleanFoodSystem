package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import connector.MysqlConnector;
import model.FoodDetailModel;

public class FoodDetailDAO {
	private Connection connect = null;
	private MysqlConnector instance = MysqlConnector.getInstance();

	public List<FoodDetailModel> getFoodDetail(int id) {
		List<FoodDetailModel> listValues = new LinkedList<>();
		FoodDetailModel model = null;
		final String QUERY = "SELECT * FROM food_detail WHERE idFood =?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		connect = instance.getDataBaseConnectionPool();
		try {
			pstm = connect.prepareStatement(QUERY);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				model = new FoodDetailModel(rs.getInt("idFoodDetail"), rs.getString("nameFoodDetail"),
						rs.getString("note"), rs.getInt("number"), rs.getString("codeQR"), rs.getInt("idManage"),
						rs.getInt("idProvider"), rs.getInt("idMarket"), rs.getInt("idFood"), rs.getString("image"));
				listValues.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closeResulset(rs);
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
		return listValues;
	}

	public void addFoodDetail(FoodDetailModel foodDetailModel) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement(
					"insert into food_detail(nameFoodDetail,note,number,codeQR,idManage,idProvider,idMarket,idFood,image) values (?, ?, ?, ?, ?, ?, ?, ?, ? )");
			pstm.setString(1, foodDetailModel.getNameFoodDetail());
			pstm.setString(2, foodDetailModel.getNote());
			pstm.setInt(3, foodDetailModel.getNumber());
			pstm.setString(4, foodDetailModel.getCodeQR());
			pstm.setInt(5, foodDetailModel.getIdManage());
			pstm.setInt(6, foodDetailModel.getIdProvider());
			pstm.setInt(7, foodDetailModel.getIdMarket());
			pstm.setInt(8, foodDetailModel.getIdFood());
			pstm.setString(9, foodDetailModel.getImage());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void deleteFoodDetail(int idFoodDetail) {
		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement("DELETE FROM food_detail WHERE idFoodDetail=?");
			pstm.setInt(1, idFoodDetail);
			pstm.executeUpdate();
			instance.closeConnection(connect);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public void updateFoodDetail(FoodDetailModel foodDetailModel) {

		PreparedStatement pstm = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			pstm = connect.prepareStatement(
					"UPDATE food_detail SET nameFoodDetail=?, note=?, number=?, codeQR=?, idManage=?, idProvider=?, idMarket=?, idFood=?, image=?  where idFoodDetail=?");
			pstm.setString(1, foodDetailModel.getNameFoodDetail());
			pstm.setString(2, foodDetailModel.getNote());
			pstm.setInt(3, foodDetailModel.getNumber());
			pstm.setString(4, foodDetailModel.getCodeQR());
			pstm.setInt(5, foodDetailModel.getIdManage());
			pstm.setInt(6, foodDetailModel.getIdProvider());
			pstm.setInt(7, foodDetailModel.getIdMarket());
			pstm.setInt(8, foodDetailModel.getIdFood());
			pstm.setString(9, foodDetailModel.getImage());
			pstm.setInt(10, foodDetailModel.getIdFootDetail());
			

			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closePrepareStatement(pstm);
			instance.closeConnection(connect);
		}
	}

	public FoodDetailModel getFoodDetailById(int idFoodDetail) {
		FoodDetailModel foodDetailModel = new FoodDetailModel();
		PreparedStatement preparedStatement = null;
		try {
			connect = instance.getDataBaseConnectionPool();
			preparedStatement = connect.prepareStatement("select * from food_detail where idFoodDetail=?");
			preparedStatement.setInt(1, idFoodDetail);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				foodDetailModel.setIdFootDetail(rs.getInt("idFoodDetail"));
				foodDetailModel.setNameFoodDetail(rs.getString("nameFoodDetail"));
				foodDetailModel.setNote(rs.getString("note"));
				foodDetailModel.setNumber(rs.getInt("number"));
				foodDetailModel.setCodeQR(rs.getString("codeQR"));
				foodDetailModel.setIdFood(rs.getInt("idFood"));
				foodDetailModel.setIdManage(rs.getInt("idManage"));
				foodDetailModel.setIdProvider(rs.getInt("idProvider"));
				foodDetailModel.setIdMarket(rs.getInt("idMarket"));
				foodDetailModel.setImage(rs.getString("image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.closeConnection(connect);
			instance.closePrepareStatement(preparedStatement);

		}

		return foodDetailModel;
	}

}
